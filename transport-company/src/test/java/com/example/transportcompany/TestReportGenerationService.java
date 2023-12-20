package com.example.transportcompany;

import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Driver;
import com.example.transportcompany.persistence.model.Request;
import com.example.transportcompany.reports.InvalidReportRequestException;
import com.example.transportcompany.reports.ReportGenerationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestReportGenerationService extends AbstractTest {

    @Autowired
    private ReportGenerationService reportGenerationService;


    @Test
    public void generateReport() throws InvalidReportRequestException, IOException, Request.BadRequetPropertyException {
        Company company = companyService.save(new Company("A"));
        Driver driver1 = driverService.save(new Driver("Ivan", "Ivanov", company));
        Driver driver2 = driverService.save(new Driver("Joro", "Ignatov", company));
        for (int i = 1; i != 10; i++) {
            if (i % 2 == 0) {
                requestService.save(buildTestRequest("Sofia", driver1, company));
            } else
                requestService.save(buildTestRequest("Karlovo", driver2, company));
        }


        File file = reportGenerationService.generate("A", Optional.empty());
        assertThat(file).exists();
    }

    protected Request buildTestRequest(String destination, Driver driver, Company company) throws Request.BadRequetPropertyException {
        Request request = super.buildTestRequest(destination);
        request.setDriver(driver);
        request.setCompany(company);
        return request;
    }
}
