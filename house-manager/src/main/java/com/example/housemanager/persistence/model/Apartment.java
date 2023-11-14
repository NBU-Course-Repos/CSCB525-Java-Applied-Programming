package com.example.housemanager.persistence.model;

import com.example.housemanager.persistence.model.composite.ApartmentId;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Apartment {

    @EmbeddedId
    private ApartmentId id;

    @Column
    private String owner;
    @Column
    private Integer inhabitants = 0;

    @Column(name = "property_tax")
    private Double propertyTax;

    @OneToMany
    private List<TaxRecord> taxRecords;

    public Apartment(Long number, Building building, String owner, Integer inhabitants, Double propertyTax) {
        this.id = new ApartmentId(number, building);
        this.owner = owner;
        this.inhabitants = inhabitants;
        this.propertyTax = propertyTax;
    }

    public Apartment() {
    }

    public ApartmentId getId() {
        return id;
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