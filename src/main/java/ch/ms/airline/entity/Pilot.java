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


    public Pilot() {
    }

    public Pilot(String firstName, String lastName) {
        this.id = java.util.UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Pilot(Pilot pilot) {
        this.id = java.util.UUID.randomUUID().toString();
        this.firstName = pilot.getFirstName();
        this.lastName = pilot.getLastName();
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
}

