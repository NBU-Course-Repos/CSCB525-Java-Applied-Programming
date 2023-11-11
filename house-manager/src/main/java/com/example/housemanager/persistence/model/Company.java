package com.example.housemanager.persistence.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @Column(nullable = false)
    private String name;

    @OneToMany
    @Column
    private List<BuildingManager> managers;

    public Company(String name, List<BuildingManager> managers) {
        this.name = name;
        this.managers = managers;
    }

    public Company(String name) {
        this.name = name;
    }

    protected Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BuildingManager> getManagers() {
        return managers;
    }

    public void setManagers(List<BuildingManager> managers) {
        this.managers = managers;
    }
}
