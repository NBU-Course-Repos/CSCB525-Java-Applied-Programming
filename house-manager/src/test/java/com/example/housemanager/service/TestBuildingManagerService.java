package com.example.housemanager.service;

import com.example.housemanager.AbstractTest;
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
}
