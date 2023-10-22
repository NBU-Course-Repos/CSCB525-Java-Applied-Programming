package com.example.housemanager.persistence.model;

import java.io.Serializable;

public class ApartmentId implements Serializable {

    private Long number;

    private Building building;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public ApartmentId(Long number, Building building) {
        this.number = number;
        this.building = building;
    }
}
