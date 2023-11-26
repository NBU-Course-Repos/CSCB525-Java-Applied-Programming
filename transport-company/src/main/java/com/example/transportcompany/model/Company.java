package com.example.transportcompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Company {

    @Id
    String name;

    @OneToMany
    Set<Driver> drivers;

    @OneToMany
    Set<Vehicle> vehicles;

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }
}
