package com.example.transportcompany.repository;

import com.example.transportcompany.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepository extends CrudRepository<Driver, UUID> {
}
