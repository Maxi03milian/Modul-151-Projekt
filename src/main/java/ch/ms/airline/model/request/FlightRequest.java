package ch.ms.airline.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class FlightRequest {

    private String flightID;

    @NotNull
    private String flightNumber;
    @NotNull
    @Size(min = 36, max = 36)
    private String departureAirportID;
    @NotNull
    @Size(min = 36, max = 36)
    private String arrivalAirportID;
    @NotNull
    private LocalDateTime departureTime;
    @NotNull
    private LocalDateTime arrivalTime;
    @NotNull
    @Size(min = 36, max = 36)
    private String aircraftID;

    public FlightRequest() {
    }

    public FlightRequest(String flightNumber, String departureAirportID, String arrivalAirportID, LocalDateTime departureTime, LocalDateTime arrivalTime, String aircraftID) {
        this.flightID = java.util.UUID.randomUUID().toString();
        this.flightNumber = flightNumber;
        this.departureAirportID = departureAirportID;
        this.arrivalAirportID = arrivalAirportID;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraftID = aircraftID;
    }

    public FlightRequest(FlightRequest flight) {
        this.flightID = java.util.UUID.randomUUID().toString();
        this.flightNumber = flight.getFlightNumber();
        this.departureAirportID = flight.getDepartureAirportID();
        this.arrivalAirportID = flight.getArrivalAirportID();
        this.departureTime = flight.getDepartureTime();
        this.arrivalTime = flight.getArrivalTime();
        this.aircraftID = flight.getAircraftID();
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportID() {
        return departureAirportID;
    }

    public void setDepartureAirportID(String departureAirportID) {
        this.departureAirportID = departureAirportID;
    }

    public String getArrivalAirportID() {
        return arrivalAirportID;
    }

    public void setArrivalAirportID(String arrivalAirportID) {
        this.arrivalAirportID = arrivalAirportID;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(String aircraftID) {
        this.aircraftID = aircraftID;
    }
}
