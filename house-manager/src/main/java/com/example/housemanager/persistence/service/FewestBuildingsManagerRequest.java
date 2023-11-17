package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.Company;

public class FewestBuildingsManagerRequest {
    public Company company;
    public BuildingManager ignore;

    public FewestBuildingsManagerRequest(Company company, BuildingManager ignore) {
        this.company = company;
        this.ignore = ignore;
    }
}
