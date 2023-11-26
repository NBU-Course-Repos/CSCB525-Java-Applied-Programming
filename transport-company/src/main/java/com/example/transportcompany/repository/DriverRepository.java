package com.example.transportcompany.repository;

import com.example.transportcompany.model.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DriverRepository extends CrudRepository<Driver, UUID> {
}
