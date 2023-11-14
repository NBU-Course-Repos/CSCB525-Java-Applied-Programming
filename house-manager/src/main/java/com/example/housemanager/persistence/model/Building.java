package com.example.housemanager.persistence.model;

import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import jakarta.persistence.*;
import org.hibernate.tool.schema.extract.internal.ForeignKeyInformationImpl;

import java.util.List;

@Entity
public class Building {

    @Id
    @Column(nullable = false)
    private String address;
    @Column
    private Integer floors;
    @OneToMany
    @Column
    private List<Apartment> apartments;
    @Column(name = "shared_space")
    private Double sharedSpace;

    @Column(name = "security_guard")
    private Boolean hasSecurityGuard;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "company", referencedColumnName = "company_name"),
            @JoinColumn(name = "building_manager", referencedColumnName = "employee_number")})
    private BuildingManager buildingManager;

    public Building(String address, Integer floors, Double sharedSpace, Boolean hasSecurityGuard, BuildingManager manager) {
        this.address = address;
        this.floors = floors;
        this.sharedSpace = sharedSpace;
        this.hasSecurityGuard = hasSecurityGuard;
        this.buildingManager = manager;
    }

    public Building() {
    }

    public Building(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public Double getSharedSpace() {
        return sharedSpace;
    }

    public Boolean getHasSecurityGuard() {
        return hasSecurityGuard;
    }

    public BuildingManager getBuildingManager() {
        return buildingManager;
    }

    public void setSharedSpace(Double sharedSpace) {
        this.sharedSpace = sharedSpace;
    }

    public void setHasSecurityGuard(Boolean hasSecurityGuard) {
        this.hasSecurityGuard = hasSecurityGuard;
    }

    public void setBuildingManager(BuildingManager buildingManager) {
        this.buildingManager = buildingManager;
    }
}
