package com.example.housemanager.persistence.model;

import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class BuildingManager {

    @EmbeddedId
    private BuildingManagerId id;
    @OneToMany(mappedBy = "buildingManager")// TODO Consider adding orphanRemoval = true
    private Set<Building> managedBuildings;

    public BuildingManagerId getId() {
        return id;
    }

    public BuildingManager(Company company) {
        this.id = new BuildingManagerId(company);
    }

    public BuildingManager() {
    }
}
