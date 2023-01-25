package ch.ms.airline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pilot {
    @Id
    @Column(length = 36, nullable = false)
    private String id;
    private String firstName;
    private String lastName;


    public Pilot() {
    }

    @JsonIgnore
    @OneToOne(mappedBy = "pilot", cascade = CascadeType.ALL)
    private Aircraft aircraft;

    public Pilot(String firstName, String lastName, Aircraft aircraft) {
        this.id = java.util.UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.aircraft = aircraft;
    }

    public Pilot(Pilot pilot) {
        this.id = java.util.UUID.randomUUID().toString();
        this.firstName = pilot.getFirstName();
        this.lastName = pilot.getLastName();
        this.aircraft = pilot.getAircraft();
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

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}

