package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.BuildingManagerId;
import com.example.housemanager.persistence.repository.BuildingManagerRepository;

public class BuildingManagerService extends AbstractEntityService<BuildingManager, BuildingManagerRepository> {
    @Override
    protected BuildingManagerId getEntityId(BuildingManager entry) {
        return new BuildingManagerId(entry.getCompany(), entry.getEmployeeNumber());
    }
}
