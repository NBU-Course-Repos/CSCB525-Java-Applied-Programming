package com.example.transportcompany.service;

import com.example.transportcompany.model.Invoice;
import com.example.transportcompany.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService extends AbstractService<Invoice, Long, InvoiceRepository> {

    @Override
    Long getId(Invoice entity) {
        return entity.getId();
    }
}
