package com.example.transportcompany.dto;

import java.math.BigDecimal;

public class DriverDTO {

    public String firstName;
    public String lastName;
    public Integer totalRequests;
    public BigDecimal earningsForPeriod;

    public DriverDTO(String firstName, String lastName, Integer totalRequests, BigDecimal earningsForPeriod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalRequests = totalRequests;
        this.earningsForPeriod = earningsForPeriod;
    }
}
