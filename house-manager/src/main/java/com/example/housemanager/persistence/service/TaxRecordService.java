package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.TaxRecord;
import com.example.housemanager.persistence.model.composite.TaxId;
import com.example.housemanager.persistence.repository.TaxRepository;

public class TaxRecordService extends AbstractEntityService<TaxRecord, TaxId, TaxRepository> {
    @Override
    protected TaxId getEntityId(TaxRecord entry) {
        return entry.getTaxId();
    }
}
