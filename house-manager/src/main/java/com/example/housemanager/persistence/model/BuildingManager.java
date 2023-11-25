package com.example.housemanager.persistence.model;

import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class BuildingManager {

    @EmbeddedId
    private BuildingManagerId id;
    @OneToMany(mappedBy = "buildingManager", fetch = FetchType.EAGER)
    private Set<Building> managedBuildings;

    @Column(name = "emloyment_time")
    private int yearsInCompany = 0;

    public BuildingManagerId getId() {
        return id;
    }

    public BuildingManager(Company company) {
        this.id = new BuildingManagerId(company);
    }

    public BuildingManager() {
    }

    public int getYearsInCompany() {
        return yearsInCompany;
    }

    public void setYearsInCompany(int yearsInCompany) {
        this.yearsInCompany = yearsInCompany;
    }

    public Set<Building> getManagedBuildings() {
        return managedBuildings;
    }
}
