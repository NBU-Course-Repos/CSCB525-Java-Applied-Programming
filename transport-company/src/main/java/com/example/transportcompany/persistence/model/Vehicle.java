package com.example.transportcompany.persistence.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vehicle_identification_number")
    UUID VIN;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    VehicleType type;

    @ManyToOne()
    @JoinColumn(nullable = false)
    Company owner;

    @OneToOne(mappedBy = "vehicle")
    Driver driver;

    public Vehicle() {
    }

    public Vehicle(VehicleType type, Company owner) {
        this.type = type;
        this.owner = owner;
    }

    public UUID getVehicleNumber() {
        return VIN;
    }

    public VehicleType getType() {
        return type;
    }

    public Company getOwner() {
        return owner;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setOwner(Company ownedBy) {
        this.owner = ownedBy;
    }

    public Driver getDriver() {
        return driver;
    }
}
