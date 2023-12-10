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

    public Invoice(Request request, BigDecimal price, Boolean isPaid) {
        this.request = request;
        this.price = price;
        this.isPaid = isPaid;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPaid(Boolean paid) {
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

    public Boolean getPaid() {
        return isPaid;
    }
}
