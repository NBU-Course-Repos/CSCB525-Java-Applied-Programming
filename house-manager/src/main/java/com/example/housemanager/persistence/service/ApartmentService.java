package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.Apartment;
import com.example.housemanager.persistence.model.ApartmentId;
import com.example.housemanager.persistence.repository.ApartmentRepository;

public class ApartmentService extends AbstractEntityService<Apartment, ApartmentRepository> {
    @Override
    protected ApartmentId getEntityId(Apartment entry) {
        return new ApartmentId(entry.getNumber(), entry.getBuilding());
    }
}
