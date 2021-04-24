package com.flights.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author sdixit
 * @since 21-04-2021
 */
@Entity
@Table(name = "AIRPORT")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @Column(name = "AIRPORT_CODE")
    private String airportCode;
    @Column(name = "AIRPORT_NAME")
    private String airportName;
    @Column(name = "CITY_NAME")
    private String cityName;
    @Column(name = "COORDINATES")
    private String coordinates;

    public Airport()
    {

    }

    public Airport(String airportCode, String airportName, String cityName, String coordinates) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.cityName = cityName;
        this.coordinates = coordinates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airpotCode) {
        this.airportCode = airpotCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
