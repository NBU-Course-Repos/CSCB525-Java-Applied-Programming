package com.example.housemanager.service;

import com.example.housemanager.AbstractTest;
import com.example.housemanager.persistence.model.Building;
import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import com.example.housemanager.persistence.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TestBuildingManagerService extends AbstractTest {

    @Test
    void saveBuildingManager() {
        Company company = new Company("Company");
        companyService.save(company);
        buildingManagerService.save(new BuildingManager(company));
        Optional<BuildingManager> manager = buildingManagerService.findById(new BuildingManagerId(company));
        assert (manager.isPresent());
        assert (manager.get().getId().getCompany().equals(company));
    }

    @Test
    void deleteBuildingManager() {
        BuildingManager manager = prepareManager();
        assert (buildingManagerService.findById(manager.getId()).isPresent());

        buildingManagerService.delete(manager);
        assert (buildingManagerService.findById(manager.getId()).isEmpty());
    }

    @Test
    void updateBuildingManager() {
        BuildingManager manager = prepareManager();
        assert (buildingManagerService.findById(manager.getId()).get().getYearsInCompany()) == 0;

        manager.setYearsInCompany(1);
        buildingManagerService.update(manager);
        assert (buildingManagerService.findById(manager.getId()).get().getYearsInCompany() == 1);
    }

    @Test
    void buildingDistribution() {
        Company company = prepareCompany();
        BuildingManager manager1 = new BuildingManager(company);
        BuildingManager manager2 = new BuildingManager(company);
        buildingManagerService.save(manager1);
        buildingManagerService.save(manager2);
        Building building = new Building("Sofia");
        building.setBuildingManager(manager1);
        buildingService.save(building);

        BuildingManager fewestBuildingsManager = buildingManagerService.managerWithFewestBuildings(company);
        assert (fewestBuildingsManager.getId().getEmployeeNumber()).equals(manager2.getId().getEmployeeNumber());

        building.setBuildingManager(manager2);
        buildingService.update(building);
        BuildingManager newFewestBuildingsManager = buildingManagerService.managerWithFewestBuildings(company);
        assert (newFewestBuildingsManager.getId().getEmployeeNumber()).equals(manager1.getId().getEmployeeNumber());

        buildingManagerService.delete(manager2);
        BuildingManager lastFewestBuildingManager = buildingManagerService.managerWithFewestBuildings(company);
        assert (lastFewestBuildingManager.getId().getEmployeeNumber()).equals(manager1.getId().getEmployeeNumber());
    }
}