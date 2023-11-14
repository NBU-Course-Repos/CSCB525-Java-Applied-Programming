package com.example.housemanager.persistence.model;

import com.example.housemanager.persistence.model.composite.TaxId;
import jakarta.persistence.*;

import java.time.YearMonth;

@Entity
public class TaxRecord {

    @EmbeddedId
    TaxId id;

    @Column(name = "is_paid")
    Boolean isPaid;

    public TaxRecord(Apartment apartment, YearMonth period, Boolean isPaid) {
        this.id = new TaxId(period, apartment);
        this.isPaid = isPaid;
    }

    public TaxRecord() {
    }

    public TaxId getTaxId() {
        return id;
    }

    public Boolean getPaid() {
        return isPaid;
    }
}
