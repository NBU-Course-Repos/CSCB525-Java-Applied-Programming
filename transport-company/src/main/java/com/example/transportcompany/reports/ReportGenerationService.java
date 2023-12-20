package com.example.transportcompany.reports;

import com.example.transportcompany.JsonUtils;
import com.example.transportcompany.Period;
import com.example.transportcompany.dto.CompanyDTO;
import com.example.transportcompany.dto.DriverDTO;
import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Driver;
import com.example.transportcompany.persistence.model.Invoice;
import com.example.transportcompany.persistence.model.Request;
import com.example.transportcompany.persistence.service.CompanyService;
import com.example.transportcompany.persistence.service.DriverService;
import com.example.transportcompany.persistence.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ReportGenerationService {

    @Autowired
    RequestService requestService;

    @Autowired
    CompanyService companyService;

    @Autowired
    DriverService driverService;

    public File generate(String companyName, Optional<Period> reportPeriod) throws InvalidReportRequestException, IOException {
        Report report = buildReportObject(companyName, reportPeriod);
        return JsonUtils.reportToJson(report);
    }

    private Report buildReportObject(String companyName, Optional<Period> reportPeriod) throws InvalidReportRequestException {
        Optional<Company> company = companyService.getById(companyName);
        validateReportRequest(company);

        List<Driver> drivers = driverService.getAllDriversWithEmployer(company.get());

        CompanyDTO companyInfo = new CompanyDTO(
                companyName,
                requestService.getRequestCountBy(company.get()),
                company.get().getEarnings(),
                calculateTotalEarnings(requestService.findAllBy(company.get(), reportPeriod.orElse(null)))
        );

        List<DriverDTO> driversInfo = drivers.stream().map(driver -> {
            List<Request> requests = requestService.findAllBy(driver, reportPeriod.orElse(null));
            return new DriverDTO(
                    driver.getFirstName(),
                    driver.getLastName(),
                    requests.size(),
                    calculateTotalEarnings(requests)
            );
        }).toList();

        return new Report(companyInfo, driversInfo);
    }

    private void validateReportRequest(Optional<Company> company) throws InvalidReportRequestException {
        if (company.isEmpty())
            throw new InvalidReportRequestException("Company does not exist!");
    }

    private BigDecimal calculateTotalEarnings(List<Request> requests) {
        BigDecimal earnings = BigDecimal.valueOf(0);
        for (Request request : requests) {
            Invoice invoice = request.getInvoice();
            if (invoice.getIsPaid())
                earnings = earnings.add(invoice.getPrice());
        }
        return earnings;
    }
}


/*
Показване на справки за общ брой извършени превози, обща сума на извършените
превози, списък с шофьорите и колко превоза е осъществил всеки от тях, приходите на
компанията за определен период от време, колко точно е приходът от всеки от
шофьорите и т.н.
 */