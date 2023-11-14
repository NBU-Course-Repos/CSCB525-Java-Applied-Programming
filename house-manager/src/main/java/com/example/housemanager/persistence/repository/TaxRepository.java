package com.example.housemanager.persistence.repository;

import com.example.housemanager.persistence.model.TaxRecord;
import com.example.housemanager.persistence.model.composite.TaxId;
import org.springframework.data.repository.CrudRepository;

public interface TaxRepository extends CrudRepository<TaxRecord, TaxId> {
}
