package com.example.housemanager.persistence.model.composite;

import com.example.housemanager.persistence.model.Company;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class BuildingManagerId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "company_name", referencedColumnName = "name")
    private Company company;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_number")
    private int employeeNumber;

    public BuildingManagerId(Company company) {
        this.company = company;
    }

    public BuildingManagerId() {
    }

    public Company getCompany() {
        return company;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }
}
