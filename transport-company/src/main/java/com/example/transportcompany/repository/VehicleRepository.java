package com.example.transportcompany.repository;

import com.example.transportcompany.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
}
