package com.example.transportcompany.persistence.service;

import com.example.transportcompany.persistence.model.Invoice;
import com.example.transportcompany.persistence.repository.CompanyRepository;
import com.example.transportcompany.persistence.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

/**
 * Service to be used for any CRUD operation, as well as necessary transformations,
 * to {@link InvoiceRepository}
 */
@Service
public class InvoiceService extends AbstractService<Invoice, Long, InvoiceRepository> {

    @Override
    Long getId(Invoice entity) {
        return entity.getId();
    }
}
