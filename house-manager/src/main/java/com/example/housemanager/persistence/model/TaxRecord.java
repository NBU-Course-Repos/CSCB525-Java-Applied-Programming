package com.example.housemanager.persistence.model;

import com.example.housemanager.persistence.model.composite.TaxId;
import jakarta.persistence.*;

@Entity
public class TaxRecord {

    @EmbeddedId
    TaxId id;

    @Column(name = "is_paid")
    Boolean isPaid;
    
    public TaxId getTaxId() {
        return id;
    }

    public Boolean getPaid() {
        return isPaid;
    }
}
