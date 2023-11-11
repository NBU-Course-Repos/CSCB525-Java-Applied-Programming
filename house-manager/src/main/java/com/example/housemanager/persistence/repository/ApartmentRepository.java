package com.example.housemanager.persistence.repository;

import com.example.housemanager.persistence.model.Apartment;
import com.example.housemanager.persistence.model.composite.ApartmentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, ApartmentId> {
}
