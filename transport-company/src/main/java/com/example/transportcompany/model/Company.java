package com.example.transportcompany.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Company {

    @Id
    String name;

    @Column(name = "address")
    String address;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.REMOVE)
    Set<Driver> drivers;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    Set<Vehicle> vehicles;

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
