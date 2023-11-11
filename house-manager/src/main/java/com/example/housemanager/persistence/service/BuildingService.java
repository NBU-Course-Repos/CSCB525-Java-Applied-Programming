package com.example.housemanager.persistence.service;


import com.example.housemanager.persistence.model.Building;
import com.example.housemanager.persistence.repository.BuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class BuildingService extends AbstractEntityService<Building, String, BuildingRepository> {

    @Override
    protected String getEntityId(Building entry) {
        return entry.getAddress();
    }
}
