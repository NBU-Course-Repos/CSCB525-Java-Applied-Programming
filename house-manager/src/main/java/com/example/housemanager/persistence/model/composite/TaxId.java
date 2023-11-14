package com.example.housemanager.persistence.model.composite;

import com.example.housemanager.persistence.model.Apartment;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.YearMonth;

@Embeddable
public class TaxId implements Serializable {

    @Column
    private YearMonth period;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "apartment_number", referencedColumnName = "number", insertable = false, updatable = false),
            @JoinColumn(name = "building", referencedColumnName = "building", insertable = false, updatable = false)
    })
    private Apartment apartment;

    public TaxId(YearMonth period, Apartment apartment) {
        this.period = period;
        this.apartment = apartment;
    }

    public TaxId() {
    }

    public YearMonth getPeriod() {
        return period;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
