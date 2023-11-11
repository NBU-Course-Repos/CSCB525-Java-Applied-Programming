package com.example.housemanager.persistence.model;

import java.io.Serializable;
import java.time.YearMonth;

public class TaxId implements Serializable {

    private YearMonth period;

    private Apartment apartment;

    public TaxId(YearMonth period, Apartment apartment) {
        this.period = period;
        this.apartment = apartment;
    }

    public TaxId() {
    }
}
