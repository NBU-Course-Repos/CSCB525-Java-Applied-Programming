package com.example.housemanager.persistence.repository;

import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingManagerRepository extends CrudRepository<BuildingManager, BuildingManagerId> {
}
