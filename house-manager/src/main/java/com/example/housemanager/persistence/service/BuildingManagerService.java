package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import com.example.housemanager.persistence.repository.BuildingManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class BuildingManagerService extends AbstractEntityService<BuildingManager, BuildingManagerId, BuildingManagerRepository> {
    @Override
    protected BuildingManagerId getEntityId(BuildingManager entry) {
        return entry.getId();
    }

    // TODO override delete to redistribute the manager's buildings
}
