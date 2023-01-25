package ch.ms.airline.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AircraftRequest {

    private String aircraftID;

    @NotNull
    private String name;

    @NotNull
    private String manufacturer;

    @NotNull
    private Integer yearManufactured;

    @NotNull
    private Integer seatCapacity;

    @NotNull
    @Size(min = 36, max = 36)
    private String pilotID;

    public AircraftRequest() {
    }

    public AircraftRequest(String name, String manufacturer, Integer yearManufactured, Integer seatCapacity, String pilotID) {
        this.aircraftID = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.manufacturer = manufacturer;
        this.yearManufactured = yearManufactured;
        this.seatCapacity = seatCapacity;
        this.pilotID = pilotID;
    }

    public AircraftRequest(AircraftRequest aircraft) {
        this.aircraftID = java.util.UUID.randomUUID().toString();
        this.name = aircraft.getName();
        this.manufacturer = aircraft.getManufacturer();
        this.yearManufactured = aircraft.getYearManufactured();
        this.seatCapacity = aircraft.getSeatCapacity();
        this.pilotID = aircraft.getPilotID();
    }

    public String getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(String aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(Integer yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getPilotID() {
        return pilotID;
    }

    public void setPilotID(String pilotID) {
        this.pilotID = pilotID;
    }
}
