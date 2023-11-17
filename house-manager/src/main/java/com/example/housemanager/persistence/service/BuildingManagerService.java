package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.Building;
import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.Company;
import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import com.example.housemanager.persistence.repository.BuildingManagerRepository;
import com.example.housemanager.persistence.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class BuildingManagerService extends AbstractEntityService<BuildingManager, BuildingManagerId, BuildingManagerRepository> {

    @Autowired
    private BuildingService buildingService;

    @Override
    protected BuildingManagerId getEntityId(BuildingManager entry) {
        return entry.getId();
    }

    public BuildingManager managerWithFewestBuildings(FewestBuildingsManagerRequest request) {
        // TODO pass an optional BuildingManager to ignore in the search
        return repository.findFirstByIdNotAndId_CompanyOrderByManagedBuildingsAsc(request.company);
    }

    @Override
    public void delete(BuildingManager entry) {
        Iterator<Building> buildings = entry.getManagedBuildings().iterator();
        Company managerCompany = entry.getId().getCompany();
        while (buildings.hasNext()) {
            Building building = buildings.next();
            building.setBuildingManager(managerWithFewestBuildings(new FewestBuildingsManagerRequest(managerCompany, entry)));
            buildingService.update(building);
        }
        repository.delete(entry);
    }
}
