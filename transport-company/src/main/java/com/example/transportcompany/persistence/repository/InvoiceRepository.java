package com.example.transportcompany.persistence.repository;

import com.example.transportcompany.persistence.model.Client;
import com.example.transportcompany.persistence.model.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for {@link Invoice} model
 */
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
