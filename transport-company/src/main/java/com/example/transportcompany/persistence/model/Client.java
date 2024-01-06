package com.example.transportcompany.persistence.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

/**
 * Persistence model for a client
 */

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID clientId;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "email", nullable = false)
    String emailAddress;

    @OneToMany
    List<Request> requests;

    public Client() {
    }

    public Client(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UUID getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Request> getRequests() {
        return requests;
    }
}
