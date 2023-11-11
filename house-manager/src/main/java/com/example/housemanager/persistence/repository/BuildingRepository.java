package com.example.housemanager.persistence.repository;

import com.example.housemanager.persistence.model.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<Building, String> {
}
