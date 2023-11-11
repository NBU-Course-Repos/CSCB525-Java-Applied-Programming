package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.Apartment;
import com.example.housemanager.persistence.model.composite.ApartmentId;
import com.example.housemanager.persistence.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService extends AbstractEntityService<Apartment, ApartmentId, ApartmentRepository> {
    @Override
    protected ApartmentId getEntityId(Apartment entry) {
        return new ApartmentId(entry.getNumber(), entry.getBuilding());
    }
}
