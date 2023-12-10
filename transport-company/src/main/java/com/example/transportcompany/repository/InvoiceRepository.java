package com.example.transportcompany.repository;

import com.example.transportcompany.model.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
