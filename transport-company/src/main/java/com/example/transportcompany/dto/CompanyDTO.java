package com.example.transportcompany.dto;

import java.math.BigDecimal;

import com.example.transportcompany.persistence.model.Company;

/**
 * DTO of {@link Company} to be used
 * in transformations, deserialization and serialization methods
 */
public class CompanyDTO {
    public String name;

    public Long totalRequests;

    public BigDecimal earnings;

    public BigDecimal earningsForPeriod;

    public CompanyDTO(String name, Long totalRequests, BigDecimal earnings, BigDecimal earningsForPeriod) {
        this.name = name;
        this.totalRequests = totalRequests;
        this.earnings = earnings;
        this.earningsForPeriod = earningsForPeriod;
    }
}
