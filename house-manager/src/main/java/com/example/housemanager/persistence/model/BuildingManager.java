package com.example.housemanager.persistence.model;

import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BuildingManager {

    @EmbeddedId
    private BuildingManagerId id;

    @OneToMany
    @JoinColumn(name = "managed_buildings")
    private List<Building> managedBuildings;

    public BuildingManager(List<Building> managedBuildings) {
        this.managedBuildings = managedBuildings;
    }

    public BuildingManagerId getId() {
        return id;
    }


    public BuildingManager(Company company) {
        this.id = new BuildingManagerId(company);
    }

    protected BuildingManager() {
    }

    public List<Building> getManagedBuildings() {
        return managedBuildings;
    }


}
