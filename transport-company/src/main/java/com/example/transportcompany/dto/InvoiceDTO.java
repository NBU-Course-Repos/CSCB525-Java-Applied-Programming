package com.example.transportcompany.dto;

import com.example.transportcompany.persistence.model.Invoice;

import java.math.BigDecimal;

/**
 * DTO of {@link Invoice} to be used
 * in transformations, deserialization and serialization methods
 */
public class InvoiceDTO {
    public BigDecimal price;
    public boolean isPaid;

    public InvoiceDTO(Invoice invoice) {
        this.price = invoice.getPrice();
        this.isPaid = invoice.getIsPaid();
    }

    public InvoiceDTO() {
    }
}
