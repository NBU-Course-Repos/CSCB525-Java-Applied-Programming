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
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
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

    public BuildingManager managerWithFewestBuildings(Company company) {
        return repository.findFirstById_CompanyOrderByManagedBuildingsAsc(company);
    }

    @Override
    public void delete(BuildingManager entry) {

        Optional<BuildingManager> manager = findById(entry.getId());
        if (manager.isEmpty())
            return;

        Iterator<Building> buildings = manager.get().getManagedBuildings().iterator();
        Company company = entry.getId().getCompany();

        while (buildings.hasNext()) {
            Building building = buildings.next();
            building.setBuildingManager(managerWithFewestBuildingsExcluding(company, entry));
            buildingService.update(building);
        }

        repository.delete(entry);
    }

    private BuildingManager managerWithFewestBuildingsExcluding(Company company, BuildingManager manager) {
        return repository.findFirstByIdNotAndId_CompanyOrderByManagedBuildingsAsc(manager.getId(), company);
    }
}
