package com.flights.services.dto;

import javax.persistence.*;
import java.sql.Time;
import java.time.format.DateTimeFormatter;

/**
 * @author sdixit
 * @since 21-04-2021
 */
@Entity
@Table(name = "FLIGHT_SCHEDULE_DETAILS")
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "FLIGHT_NUMBER")
    private String flightNumber;
    @Column(name = "DEPARTURE_AIRPORT")
    private String departureAirport;
    @Column(name = "ARRIVAL_AIRPORT")
    private String arrivalAirport;
    @Column(name = "DEPARTURE_TIME")
    private Time departureTime;
    @Column(name = "ARRIVAL_TIME")
    private Time arrivalTime;

    public  FlightSchedule(){

    }

    public FlightSchedule(String flightNumber, String departureAirport, String arrivalAirport, Time departureTime, Time arrivalTime) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
