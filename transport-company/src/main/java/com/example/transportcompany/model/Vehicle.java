package com.example.transportcompany.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID serialNumber;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    VehicleType type;

    @ManyToOne
    @JoinColumn(nullable = false)
    Company owner;

    public Vehicle() {
    }

    public UUID getSerialNumber() {
        return serialNumber;
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
}
