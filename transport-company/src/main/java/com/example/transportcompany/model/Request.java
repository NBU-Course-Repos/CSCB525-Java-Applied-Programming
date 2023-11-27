package com.example.transportcompany.model;

import jakarta.persistence.*;
import org.joda.time.DateTime;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long requestId;

    @ManyToOne
    @JoinColumn(nullable = false)
    Client client;

    @ManyToOne
    @JoinColumn(nullable = false)
    Company company;

    @Column(nullable = false)
    String origin;

    @Column(nullable = false)
    String destination;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "departure_date")
    DateTime departureDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "arrival_date")
    DateTime arrivalDate;

    @Column(nullable = false)
    @Enumerated
    RequestStatus status = RequestStatus.TRIAGE;

    @Column(nullable = false)
    @Enumerated
    RequestFor requestFor;
    //TODO Think of using a Builder or a Factory


    public void setClient(Client client) {
        this.client = client;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(DateTime departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(DateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setRequestFor(RequestFor requestFor) {
        this.requestFor = requestFor;
    }

    public Long getRequestId() {
        return requestId;
    }

    public Client getClient() {
        return client;
    }

    public Company getCompany() {
        return company;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public DateTime getArrivalDate() {
        return arrivalDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public RequestFor getRequestFor() {
        return requestFor;
    }
}
