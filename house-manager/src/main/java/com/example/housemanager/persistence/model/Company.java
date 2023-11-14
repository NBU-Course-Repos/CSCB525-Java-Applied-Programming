package com.example.housemanager.persistence.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bulstat;

    @Column(nullable = false, unique = true)
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

    public String getId() {
        return bulstat;
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
