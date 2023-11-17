package com.example.housemanager.persistence.model.composite;

import com.example.housemanager.persistence.model.Company;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class BuildingManagerId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "company_name", referencedColumnName = "name")
    private Company company;

    @Column(name = "employee_number", unique = true)
    private UUID employeeNumber;

    public BuildingManagerId(Company company) {
        this.company = company;
        employeeNumber = UUID.randomUUID();
    }

    public BuildingManagerId() {
    }

    public Company getCompany() {
        return company;
    }

    public UUID getEmployeeNumber() {
        return employeeNumber;
    }
}
