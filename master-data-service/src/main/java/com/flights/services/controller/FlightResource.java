package com.flights.services.controller;


import com.flights.services.dto.Airport;
import com.flights.services.services.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author sdixit
 * @since 21-04-2021
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlightResource {

    private final static Logger logger = LoggerFactory.getLogger(FlightResource.class);

    @Autowired
    private AirportService airportService;

    public AirportService getAirportService() {
        return airportService;
    }

    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public List<Airport> getAirports() {
        List<Airport> airports = airportService.retrieveAirports();
        logger.info("Data Retrieved Successfully");
        return airports;
    }

    @GetMapping("/airports/{airportcode}")
    public Airport getAirport(@PathVariable(name = "airportcode") String airportcode) {
        return airportService.getAirport(airportcode);
    }

    @PostMapping("/airports")
    public void saveAirport(@RequestBody Airport airport) {
        airportService.saveAirport(airport);
        logger.info("Airport Saved Successfully");
    }

    @DeleteMapping("/airports/{airportCode}")
    public void deleteAirport(@PathVariable(name = "airportCode") String airportcode)       {
        airportService.deleteAirport(airportcode);
        logger.info("Airport Deleted Successfully");
    }

    @PutMapping("/airports/{airportCode}")
    public void updateAirport(@RequestBody Airport airportReq,
                               @PathVariable(name = "airportCode") String airportcode)     {
        Airport airport = airportService.getAirport(airportcode);

        if (airport != null) {
            airportService.updateAirport(airportReq);
            logger.info("Airport Updated Successfully");
        }
    }
}
