package com.flights.services.services;


import com.flights.services.dto.Airport;

import java.util.List;

/**
 * @author sdixit
 * @since 21-04-2021
 */
public interface AirportService {


    public List<Airport> retrieveAirports();

    public Airport getAirport(String airportCode);

    public void saveAirport(Airport airport);

    public void deleteAirport(String airportCode);

    public void updateAirport(Airport airport);
}
