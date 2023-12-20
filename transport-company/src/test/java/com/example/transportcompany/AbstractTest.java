package com.example.transportcompany;

import com.example.transportcompany.persistence.model.*;
import com.example.transportcompany.persistence.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractTest {

    private final String CLEANUP_MESSAGE = "Deleting all entries of type ";
    private final Logger logger = LoggerFactory.getLogger("Test Cleanup");
    private Map<AbstractService, Class> cleanUpMap;

    @Autowired
    protected CompanyService companyService;

    @Autowired
    protected ClientService clientService;

    @Autowired
    protected DriverService driverService;

    @Autowired
    protected InvoiceService invoiceService;

    @Autowired
    protected RequestService requestService;

    @Autowired
    protected VehicleService vehicleService;

    @BeforeAll
    protected void setup() throws Request.BadRequetPropertyException, InterruptedException {
        setupCleanupMap();
    }

    @BeforeEach
    protected void cleanup() {
        cleanUpMap.forEach((key, value) -> {
            logger.info(CLEANUP_MESSAGE + value);
            key.deleteAll();
        });
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

    protected Request buildTestRequest(String destination) throws Request.BadRequetPropertyException {
        return new Request.RequestBuilder()
                .client(clientService.save(new Client("a", "a", "123", "a@a.a")))
                .company(companyService.save(new Company("Speedn't")))
                .origin("Sofia")
                .destination(destination)
                .departureDate(Date.valueOf(LocalDate.now()))
                .status(RequestStatus.TRIAGE)
                .requestType(RequestType.FREIGHT)
                .freightWeight(BigDecimal.valueOf(100))
                .invoice(new Invoice(BigDecimal.valueOf(Instant.now().getNano() / 1000), true))
                .build();
    }
}
