package com.example.transportcompany.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(mappedBy = "invoice")
    Request request;

    @Column
    BigDecimal price;

    @Column(name = "is_paid")
    Boolean isPaid;

    public Invoice(BigDecimal price, Boolean isPaid) {
        this.price = price;
        this.isPaid = isPaid;
    }

    public Invoice() {
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setIsPaid(Boolean paid) {
        isPaid = paid;
    }

    public Long getId() {
        return id;
    }

    public Request getRequest() {
        return request;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }
}
