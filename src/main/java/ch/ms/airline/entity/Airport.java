package ch.ms.airline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {
    @Id
    @Column(length = 36, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "departureAirport", fetch = FetchType.LAZY)
    private List<Flight> departureFlights;
    @JsonIgnore
    @OneToMany(mappedBy = "arrivalAirport", fetch = FetchType.LAZY)
    private List<Flight> arrivalFlights;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "pilot-airport",
            joinColumns = @JoinColumn(name = "pilot_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id"))
    private List<Pilot> pilots = new ArrayList<>();


    public Airport() {
    }

    public Airport(String name, String code, String city, String country, List<Flight> departureFlights, List<Flight> arrivalFlights, List<Pilot> pilots) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
        this.departureFlights = departureFlights;
        this.arrivalFlights = arrivalFlights;
        this.pilots = pilots;
    }

    public Airport(Airport airport) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = airport.getName();
        this.code = airport.getCode();
        this.city = airport.getCity();
        this.country = airport.getCountry();
        this.departureFlights = airport.getDepartureFlights();
        this.arrivalFlights = airport.getArrivalFlights();
        this.pilots = airport.getPilots();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Flight> getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(List<Flight> departureFlights) {
        this.departureFlights = departureFlights;
    }

    public List<Flight> getArrivalFlights() {
        return arrivalFlights;
    }

    public void setArrivalFlights(List<Flight> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }
}

