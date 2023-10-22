package com.example.housemanager.persistence.model;

import java.io.Serializable;

public class BuildingManagerId implements Serializable {

    private Company company;

    private Long employeeNumber;

    public BuildingManagerId(Company company, Long employeeNumber) {
        this.company = company;
        this.employeeNumber = employeeNumber;
    }
}
