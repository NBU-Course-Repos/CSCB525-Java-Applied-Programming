package com.example.housemanager;

import com.example.housemanager.persistence.service.ApartmentService;
import com.example.housemanager.persistence.service.BuildingManagerService;
import com.example.housemanager.persistence.service.BuildingService;
import com.example.housemanager.persistence.service.CompanyService;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractTest {

    @Autowired
    protected CompanyService companyService;

    @Autowired
    protected BuildingService buildingService;

    @Autowired
    protected BuildingManagerService buildingManagerService;

    @Autowired
    protected ApartmentService apartmentService;

    @AfterEach
    void cleanUp() {
        apartmentService.deleteAll();
        buildingService.deleteAll();
        buildingManagerService.deleteAll();
        companyService.deleteAll();
    }
}
