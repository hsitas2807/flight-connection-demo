package com.flights.services.services;



import com.flights.services.dto.Connections;

/**
 * @author sdixit
 * @since 21-04-2021
 */

public interface FlightScheduleService {

    public Connections retrieveFlightSchedules(String depAirport, String arrAirport);

}
