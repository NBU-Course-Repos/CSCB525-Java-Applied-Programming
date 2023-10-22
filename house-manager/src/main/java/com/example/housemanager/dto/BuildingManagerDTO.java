package com.example.housemanager.dto;

import com.example.housemanager.persistence.model.Building;
import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class BuildingManagerDTO extends AbstractDTO<BuildingManager> {

    public Long employeeNumber;

    public List<Building> managedBuildings;

    public String companyName;

    public BuildingManager toEntity() {
        //TODO
        return new BuildingManager();
    }
}
