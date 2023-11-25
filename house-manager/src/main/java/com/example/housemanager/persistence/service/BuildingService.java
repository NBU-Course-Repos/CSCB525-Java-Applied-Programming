package com.example.housemanager.persistence.service;


import com.example.housemanager.persistence.model.Building;
import com.example.housemanager.persistence.model.Company;
import com.example.housemanager.persistence.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService extends AbstractEntityService<Building, String, BuildingRepository> {

    @Autowired
    BuildingManagerService managerService;

    @Override
    protected String getEntityId(Building entry) {
        return entry.getAddress();
    }

    public void save(Building entry, Company company) {
        Building building = assignManager(entry, company);
        super.save(building);
    }

    private Building assignManager(Building building, Company company) {
        building.setBuildingManager(managerService.managerWithFewestBuildings(company));
        return building;
    }
}
