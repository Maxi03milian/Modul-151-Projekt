package ch.ms.airline.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pilot {
    @Id
    @Column(length = 36, nullable = false)
    private String id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "pilot")
    private List<Flight> flights;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;


    public Pilot() {
    }

    public Pilot(String firstName, String lastName, List<Flight> flights, Aircraft aircraft, Airport airport) {
        this.id = java.util.UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.flights = flights;
        this.aircraft = aircraft;
        this.airport = airport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}

