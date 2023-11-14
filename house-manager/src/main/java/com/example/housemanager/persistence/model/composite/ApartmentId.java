package com.example.housemanager.persistence.model.composite;

import com.example.housemanager.persistence.model.Building;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ApartmentId implements Serializable {

    @Column
    private Long number;

    @JoinColumn(name = "building")
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
