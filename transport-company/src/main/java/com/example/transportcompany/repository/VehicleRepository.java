package com.example.transportcompany.repository;

import com.example.transportcompany.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
}
