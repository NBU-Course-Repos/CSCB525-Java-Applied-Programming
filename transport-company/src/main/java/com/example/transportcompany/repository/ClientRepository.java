package com.example.transportcompany.repository;

import com.example.transportcompany.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> {
}
