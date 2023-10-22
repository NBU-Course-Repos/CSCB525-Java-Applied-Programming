package com.example.housemanager.persistence.model;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

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
    @Column(name = "building_manager")
    private BuildingManager buildingManager;

    public Building(String address, Integer floors, List<Apartment> apartments, Double sharedSpace, Boolean hasSecurityGuard, BuildingManager buildingManager) {
        this.address = address;
        this.floors = floors;
        this.apartments = apartments;
        this.sharedSpace = sharedSpace;
        this.hasSecurityGuard = hasSecurityGuard;
        this.buildingManager = buildingManager;
    }

    public Building() {
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

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Double getSharedSpace() {
        return sharedSpace;
    }

    public void setSharedSpace(Double sharedSpace) {
        this.sharedSpace = sharedSpace;
    }

    public Boolean getHasSecurityGuard() {
        return hasSecurityGuard;
    }

    public void setHasSecurityGuard(Boolean hasSecurityGuard) {
        this.hasSecurityGuard = hasSecurityGuard;
    }

    public BuildingManager getBuildingManager() {
        return buildingManager;
    }

    public void setBuildingManager(BuildingManager buildingManager) {
        this.buildingManager = buildingManager;
    }
}
