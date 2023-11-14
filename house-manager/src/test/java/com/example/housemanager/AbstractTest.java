package com.example.housemanager;

import com.example.housemanager.persistence.model.*;
import com.example.housemanager.persistence.service.*;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Month;
import java.time.YearMonth;


public abstract class AbstractTest {

    @Autowired
    protected CompanyService companyService;

    @Autowired
    protected BuildingService buildingService;

    @Autowired
    protected BuildingManagerService buildingManagerService;

    @Autowired
    protected ApartmentService apartmentService;

    @Autowired
    protected TaxRecordService taxRecordService;

    @AfterEach
    void cleanUp() {
        apartmentService.deleteAll();
        buildingService.deleteAll();
        buildingManagerService.deleteAll();
        companyService.deleteAll();
    }

    protected Company prepareCompany() {
        Company company = new Company("Company");
        companyService.save(company);
        return company;
    }

    protected BuildingManager prepareManager() {
        BuildingManager manager = new BuildingManager(prepareCompany());
        buildingManagerService.save(manager);
        return manager;
    }

    protected Building prepareBuilding() {
        Building building = new Building("address", 2, 10.0, false, prepareManager());
        buildingService.save(building);
        return building;
    }

    protected Apartment prepareApartment() {
        Apartment apartment = new Apartment(123L, prepareBuilding(), "Georgi Georgiev", 1, 300.0);
        apartmentService.save(apartment);
        return apartment;
    }

    protected TaxRecord prepareTaxRecord() {
        TaxRecord taxRecord = new TaxRecord(prepareApartment(), YearMonth.of(2023, Month.DECEMBER), false);
        taxRecordService.save(taxRecord);
        return taxRecord;
    }

}
