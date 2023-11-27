package com.example.transportcompany.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TransportRequestId {

    @ManyToOne
    Client client;

    @ManyToOne
    Company company;

    
}
