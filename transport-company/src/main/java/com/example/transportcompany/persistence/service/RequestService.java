package com.example.transportcompany.persistence.service;

import com.example.transportcompany.Period;
import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Driver;
import com.example.transportcompany.persistence.model.Invoice;
import com.example.transportcompany.persistence.model.Request;
import com.example.transportcompany.persistence.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class RequestService extends AbstractService<Request, Long, RequestRepository> {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private CompanyService companyService;

    @Override
    Long getId(Request entity) {
        return entity.getRequestId();
    }

    @Override
    public Request save(Request entity) {
        super.save(entity);
        if (entity.getInvoice().getIsPaid())
            companyService.addToEarnings(entity.getCompany(), entity.getInvoice().getPrice());
        
        return entity;
    }

    public void payInvoice(Request request) {
        Invoice invoice = request.getInvoice();

        if (invoice.getIsPaid())
            logger.info("Invoice for request " + request.getRequestId() + " is already paid.");
        invoice.setIsPaid(true);
        invoiceService.update(invoice);

        companyService.addToEarnings(
                request.getCompany(),
                request.getInvoice().getPrice()
        );
    }

    public List<Request> orderAllByDestination() {
        return repository.findAllByOrderByDestinationAsc();
    }

    public List<Request> findAllBy(String destination) {
        return repository.findAllByDestinationContaining(destination);
    }

    public List<Request> findAllBy(Driver driver, Period period) {
        Period validatedPeriod = validatePeriod(period);
        return repository.findAllByDriverAndDepartureDateBetween(driver, validatedPeriod.startDate, validatedPeriod.endDate);
    }

    public List<Request> findAllBy(Company company, Period period) {
        Period validatedPeriod = validatePeriod(period);
        return repository.findAllByCompanyAndDepartureDateBetween(company, validatedPeriod.startDate, validatedPeriod.endDate);
    }

    private Period validatePeriod(Period period) {
        if (period == null)
            return new Period(Date.from(Instant.ofEpochMilli(0)), Date.from(Instant.now()));
        return period;
    }

    public Integer getRequestCountBy(Driver driver) {
        return repository.countByDriver(driver);
    }

    public Long getRequestCountBy(Company company) {
        return repository.countByCompany(company);
    }

    private final Logger logger = LoggerFactory.getLogger(RequestService.class);
}
