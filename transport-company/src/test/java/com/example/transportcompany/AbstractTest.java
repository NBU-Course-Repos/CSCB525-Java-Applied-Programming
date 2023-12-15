package com.example.transportcompany;

import com.example.transportcompany.model.*;
import com.example.transportcompany.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractTest {

    private final String CLEANUP_MESSAGE = "Deleting all entries of type ";
    private final Logger logger = LoggerFactory.getLogger("Test Cleanup");
    private Map<AbstractService, Class> cleanUpMap;

    @Autowired
    CompanyService companyService;

    @Autowired
    ClientService clientService;

    @Autowired
    DriverService driverService;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    RequestService requestService;

    @Autowired
    VehicleService vehicleService;

    @BeforeAll
    void setup() {
        setupCleanupMap();
    }

    @BeforeEach
    void cleanup() {
//        cleanUpMap.forEach((key, value) -> {
//            logger.info(CLEANUP_MESSAGE + value);
//            key.deleteAll();
//        });
        requestService.deleteAll();
        invoiceService.deleteAll();
        clientService.deleteAll();
        vehicleService.deleteAll();
        driverService.deleteAll();
        companyService.deleteAll();
    }

    private void setupCleanupMap() {
        cleanUpMap = Map.of(
                requestService, Request.class,
                invoiceService, Invoice.class,
                clientService, Client.class,
                vehicleService, Vehicle.class,
                driverService, Driver.class,
                companyService, Company.class
        );
    }
}
