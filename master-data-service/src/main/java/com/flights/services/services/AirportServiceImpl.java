package com.flights.services.services;

import com.flights.services.dto.Airport;
import com.flights.services.repository.AirportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author sdixit
 * @since 21-04-2021
 */
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public AirportRepository getAirportRepository() {
        return airportRepository;
    }

    public void setAirportRepository(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> retrieveAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports;
    }

    @Override
    public Airport getAirport(String airportCode) {
        List<Airport> airports = airportRepository.findAll();
        for (Airport airport : airports) {
            if (airport.getAirportCode().equalsIgnoreCase(airportCode))
                return airport;
        }
        return null;
    }

    @Override
    public void saveAirport(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(String airportCode) {
        List<Airport> flightSchedules = airportRepository.findAll();
        for (Airport airport : flightSchedules) {
            if (airport.getAirportCode().equalsIgnoreCase(airportCode))
                airportRepository.deleteById(airport.getId());
        }
    }

    @Override
    public void updateAirport(Airport airport) {
        airportRepository.save(airport);
    }
}
