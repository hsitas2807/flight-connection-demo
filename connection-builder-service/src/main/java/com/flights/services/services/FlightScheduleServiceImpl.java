package com.flights.services.services;

import com.flights.services.controller.FlightConnectionResource;
import com.flights.services.dto.Connections;
import com.flights.services.dto.ConnectionData;
import com.flights.services.dto.FlightSchedule;
import com.flights.services.repository.FlightScheduleRepository;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sdixit
 * @since 21-04-2021
 */
@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

    private final static Logger logger = LoggerFactory.getLogger(FlightScheduleServiceImpl.class);
    private final static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm");
    private final static long MIN_WAITING_TIME_IN_MINUTES=120;
    private final static long MAX_WAITING_TIME_IN_MINUTES=480;

    @Autowired
    private FlightScheduleRepository flightScheduleRepository;

    public FlightScheduleRepository getFlightScheduleRepository() {
        return flightScheduleRepository;
    }

    public void setFlightScheduleRepository(FlightScheduleRepository flightScheduleRepository) {
        this.flightScheduleRepository = flightScheduleRepository;
    }

    @Override
    public Connections retrieveFlightSchedules(String depAirport, String arrAirport) {
        logger.info("Processing inside service FlightScheduleServiceImpl");
        List<FlightSchedule> flightSchedules = flightScheduleRepository.findAll();
        Connections connections =getAllApplicableFlights(flightSchedules,depAirport,arrAirport);
        logger.info("Processing finished");
        return connections;
    }

    /**
     *  Get all applicable flights between depAirport and arrAirport
     *
     * @param flightSchedules
     * @param depAirport
     * @param arrAirport
     * @return
     */
    private Connections getAllApplicableFlights(List<FlightSchedule> flightSchedules, String depAirport, String arrAirport )
    {
        //create list based on departure airport
        List<FlightSchedule> departureFlightSchedules=flightSchedules.stream().filter(
                flightSchedule -> flightSchedule.getDepartureAirport().equalsIgnoreCase(depAirport)
        ).collect(Collectors.toList());
        //create list based on arrival airport
        List<FlightSchedule> arrivalFlightSchedules=flightSchedules.stream().filter(
                flightSchedule -> flightSchedule.getArrivalAirport().equalsIgnoreCase(arrAirport)
        ).collect(Collectors.toList());

        Connections connections = new Connections();
        if(!departureFlightSchedules.equals(arrivalFlightSchedules)) {

            departureFlightSchedules.stream().forEach(
                    depFlightSchedule -> {
                        arrivalFlightSchedules.stream().forEach(arrFlightSchedule ->
                        {
                            LocalTime depFlightArrivalTime = depFlightSchedule.getArrivalTime().toLocalTime();
                            LocalTime arrFlightDepartureTime = arrFlightSchedule.getDepartureTime().toLocalTime();
                            if (depFlightArrivalTime.isBefore(arrFlightDepartureTime)) {
                                long offsetDifference = ChronoUnit.MINUTES.between(depFlightArrivalTime, arrFlightDepartureTime);
                                if (offsetDifference > MIN_WAITING_TIME_IN_MINUTES && offsetDifference < MAX_WAITING_TIME_IN_MINUTES) {
                                    ConnectionData connectionData = new ConnectionData();
                                    populateConnectionDetails(connectionData, depFlightSchedule, arrFlightSchedule);
                                    connections.getConnectionData().add(connectionData);

                                }
                            } else if (depFlightArrivalTime.isAfter(arrFlightDepartureTime)) {
                                long offsetDifference = ChronoUnit.MINUTES.between(depFlightArrivalTime, arrFlightDepartureTime);
                                long offsetDifferenceNew = 1440 + offsetDifference;
                                if (offsetDifferenceNew > MIN_WAITING_TIME_IN_MINUTES && offsetDifferenceNew < MAX_WAITING_TIME_IN_MINUTES) {
                                    ConnectionData connectionData = new ConnectionData();
                                    populateConnectionDetails(connectionData, depFlightSchedule, arrFlightSchedule);
                                    connections.getConnectionData().add(connectionData);

                                }
                            }
                        });
                    }
            );
        }
        else if(departureFlightSchedules.equals(arrivalFlightSchedules))
        {
            departureFlightSchedules.stream().forEach(
                    depFlightSchedule -> {
                        ConnectionData connectionData = new ConnectionData();
                        populateConnectionDetails(connectionData, depFlightSchedule, null);
                        connections.getConnectionData().add(connectionData);
                    });
        }

        return connections;

    }

    /**
     *   populate connection details data.
     *
     * @param connectionData
     * @param depFlightSchedule
     * @param arrFlightSchedule
     */
    private void populateConnectionDetails(ConnectionData connectionData, FlightSchedule depFlightSchedule, FlightSchedule arrFlightSchedule)
    {   if(depFlightSchedule!=null) {
        connectionData.setOnwardFltNo(depFlightSchedule.getFlightNumber());
        connectionData.setOnwardDepArpt(depFlightSchedule.getDepartureAirport());
        connectionData.setOnwardArrArpt(depFlightSchedule.getArrivalAirport());
        connectionData.setOnwardDepTime(depFlightSchedule.getDepartureTime().toLocalTime().format(formatter).toString());
        connectionData.setOnwardArrTime(depFlightSchedule.getArrivalTime().toLocalTime().format(formatter).toString());
    }
        if(arrFlightSchedule!=null) {
            connectionData.setConnFltNo(arrFlightSchedule.getFlightNumber());
            connectionData.setConnDepArpt(arrFlightSchedule.getDepartureAirport());
            connectionData.setConnArrArpt(arrFlightSchedule.getArrivalAirport());
            connectionData.setConnDepTime(arrFlightSchedule.getDepartureTime().toLocalTime().format(formatter).toString());
            connectionData.setConnArrTime(arrFlightSchedule.getArrivalTime().toLocalTime().format(formatter).toString());
        }
    }

}
