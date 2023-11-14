package com.example.housemanager.service;

import com.example.housemanager.AbstractTest;
import com.example.housemanager.persistence.model.Building;
import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TestBuildingService extends AbstractTest {

    @Test
    void saveBuilding() {
        Company company = new Company("Company");
        companyService.save(company);
        BuildingManager manager = new BuildingManager(company);
        buildingManagerService.save(manager);

        final String address = "Sofia 1st street";
        buildingService.save(
                new Building(
                        address,
                        7,
                        10.5,
                        true,
                        manager
                )
        );

        Optional<Building> building = buildingService.findById(address);
        assert (building.isPresent());
        assert (building.get().getAddress().equals(address));
        assert (building.get().getFloors().equals(7));
        assert (building.get().getBuildingManager().getId().getEmployeeNumber() == (manager.getId().getEmployeeNumber()));
    }

    @Test
    void deleteBuilding() {
        Building building = prepareBuilding();
        assert (buildingService.findById(building.getAddress()).isPresent());

        buildingService.delete(building);
        assert (buildingService.findById(building.getAddress()).isEmpty());
    }

    @Test
    void updateBuilding() {
        Building building = prepareBuilding();
        assert (building.getHasSecurityGuard().equals(false));

        building.setHasSecurityGuard(true);
        buildingService.update(building);
        assert (buildingService.findById(building.getAddress()).isPresent());
        assert (buildingService.findById(building.getAddress()).get().getHasSecurityGuard().equals(true));
    }
}
