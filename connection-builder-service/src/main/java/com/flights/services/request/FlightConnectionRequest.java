package com.flights.services.request;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author sdixit
 * @since 21-04-2021
 */
public class FlightConnectionRequest {
    @JsonValue()
    private String depAirport;
    private String arrAirport;

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }
}
