package com.example.housemanager.persistence.model.composite;

import com.example.housemanager.persistence.model.Building;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ApartmentId implements Serializable {

    @Column
    private Long number;

    @JoinColumn
    @ManyToOne
    private Building building;

    public ApartmentId() {
    }

    public Long getNumber() {
        return number;
    }

    public Building getBuilding() {
        return building;
    }

    public ApartmentId(Long number, Building building) {
        this.number = number;
        this.building = building;
    }
}
