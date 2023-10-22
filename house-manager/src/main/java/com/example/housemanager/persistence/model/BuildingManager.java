package com.example.housemanager.persistence.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@IdClass(BuildingManagerId.class)
public class BuildingManager {

    @Id
    @ManyToOne
    @Column(nullable = false)
    private Company company;

    @Id
    @Column(name = "employee_number", nullable = false)
    private Long employeeNumber;

    @OneToMany
    @Column(name = "managed_buildings")
    private List<Building> managedBuildings;

    public BuildingManager(Company company, Long employeeNumber, List<Building> managedBuildings) {
        this.company = company;
        this.employeeNumber = employeeNumber;
        this.managedBuildings = managedBuildings;
    }

    public BuildingManager() {
    }

    public Company getCompany() {
        return company;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public List<Building> getManagedBuildings() {
        return managedBuildings;
    }


}
