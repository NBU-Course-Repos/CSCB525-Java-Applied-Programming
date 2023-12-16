package com.example.transportcompany.persistence.service;

import com.example.transportcompany.persistence.model.Invoice;
import com.example.transportcompany.persistence.model.Request;
import com.example.transportcompany.persistence.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Request> findAllByDestination(String destination) {
        return repository.findAllByDestinationContaining(destination);
    }

    private final Logger logger = LoggerFactory.getLogger(RequestService.class);
}
