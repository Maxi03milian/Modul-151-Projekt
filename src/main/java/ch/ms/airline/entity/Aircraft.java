package ch.ms.airline.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aircraft {
    @Id
    @Column(length = 36, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "year_manufactured")
    private Integer yearManufactured;

    @Column(name = "seat_capacity")
    private Integer seatCapacity;

    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY)
    private List<Flight> flights;


    public Aircraft() {
    }

    public Aircraft(String name, String manufacturer, Integer yearManufactured, Integer seatCapacity, List<Flight> flights) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.manufacturer = manufacturer;
        this.yearManufactured = yearManufactured;
        this.seatCapacity = seatCapacity;
        this.flights = flights;
    }

    public Aircraft(Aircraft aircraft) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = aircraft.getName();
        this.manufacturer = aircraft.getManufacturer();
        this.yearManufactured = aircraft.getYearManufactured();
        this.seatCapacity = aircraft.getSeatCapacity();
        this.flights = aircraft.getFlights();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


}
