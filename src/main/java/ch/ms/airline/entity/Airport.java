package ch.ms.airline.entity;

import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "departureAirport", fetch = FetchType.LAZY)
    private List<Flight> departureFlights;

    @OneToMany(mappedBy = "arrivalAirport", fetch = FetchType.LAZY)
    private List<Flight> arrivalFlights;


    public Airport() {
    }

    public Airport(String name, String code, String city, String country, List<Flight> departureFlights, List<Flight> arrivalFlights) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
        this.departureFlights = departureFlights;
        this.arrivalFlights = arrivalFlights;
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
}

