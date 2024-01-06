package com.example.transportcompany;

import java.util.Date;

/**
 * A period abstractions, containing a start {@link Date} and an end {@link Date}
 */
public class Period {

    public Date startDate;
    public Date endDate;

    public Period(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
