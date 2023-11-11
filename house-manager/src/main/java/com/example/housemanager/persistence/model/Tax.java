//package com.example.housemanager.persistence.model;
//
//import jakarta.persistence.*;
//
//import java.time.YearMonth;
//
//@Entity
//@IdClass(TaxId.class)
//public class Tax {
//
//    @Id
//    YearMonth period;
//
//    @Id
//    @ManyToOne
//    Apartment apartment;
//
//    @Column
//    Boolean isPaid;
//
//    public TaxId getTaxId() {
//        return new TaxId(period, apartment);
//    }
//}
