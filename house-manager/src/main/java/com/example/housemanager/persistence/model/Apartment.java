package com.example.housemanager.persistence.model;

import jakarta.persistence.*;

@Entity
@IdClass(ApartmentId.class)
public class Apartment {

    @Id
    @Column(name = "number", nullable = false)
    private Long number;

    @Id
    @ManyToOne
    @Column(nullable = false)
    private Building building;

    @Column
    private String owner;

    @Column
    private Integer inhabitants = 0;

    @Column(name = "property_tax")
    private Double propertyTax;

    public Apartment(Long number, Building building, String owner, Integer inhabitants, Double propertyTax) {
        this.number = number;
        this.building = building;
        this.owner = owner;
        this.inhabitants = inhabitants;
        this.propertyTax = propertyTax;
    }

    public Apartment() {
    }

    public Long getNumber() {
        return number;
    }

    public Building getBuilding() {
        return building;
    }

    public String getOwner() {
        return owner;
    }

    public Integer getInhabitants() {
        return inhabitants;
    }

    public Double getPropertyTax() {
        return propertyTax;
    }
}
