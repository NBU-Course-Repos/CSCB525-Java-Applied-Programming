package com.example.transportcompany.persistence.repository;

import com.example.transportcompany.persistence.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * CRUD repository for {@link Client} model
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> {
}
