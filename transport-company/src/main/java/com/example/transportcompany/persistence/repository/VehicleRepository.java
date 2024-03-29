package com.example.transportcompany.persistence.repository;

import com.example.transportcompany.persistence.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * CRUD repository for {@link Vehicle} model
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
}
