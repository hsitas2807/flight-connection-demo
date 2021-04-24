package com.flights.services.controller;

import com.flights.services.dto.Connections;
import com.flights.services.request.FlightConnectionRequest;
import com.flights.services.services.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author sdixit
 * @since 21-04-2021
 */
@RestController
@RequestMapping(value="/api", produces="application/json", consumes="application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlightConnectionResource {

    private final static Logger logger = LoggerFactory.getLogger(FlightConnectionResource.class);

    @Autowired
    private FlightScheduleService flightScheduleService;

    @PostMapping("/flightconnections")
    public ResponseEntity<Connections> getAllAvailableFlight(@RequestBody FlightConnectionRequest flightConnectionRequest) {
        Connections connections;
        try {
            if(flightConnectionRequest!=null && !flightConnectionRequest.getDepAirport().isEmpty()
            && !flightConnectionRequest.getArrAirport().isEmpty()) {
                logger.info("Input: Departure Airport: {} , Arrival Airport: {}", flightConnectionRequest.getDepAirport(), flightConnectionRequest.getArrAirport());
                connections = flightScheduleService.retrieveFlightSchedules(flightConnectionRequest.getDepAirport(), flightConnectionRequest.getArrAirport());
                logger.info("Response received Applicable flights Size: {}", connections.getConnectionData().size());
                return new ResponseEntity<Connections>(connections, HttpStatus.OK);
            }
            else
            {
                logger.info("Input parameters are not correctly passed.");
                connections =new Connections();
                return new ResponseEntity<Connections>(connections,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            connections =null;
            return new ResponseEntity<Connections>(connections,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
