package com.example.transportcompany.service;

import com.example.transportcompany.model.Invoice;
import com.example.transportcompany.model.Request;
import com.example.transportcompany.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService extends AbstractService<Request, Long, RequestRepository> {

    @Autowired
    private InvoiceService invoiceService;

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
    }

    private final Logger logger = LoggerFactory.getLogger(RequestService.class);
}
