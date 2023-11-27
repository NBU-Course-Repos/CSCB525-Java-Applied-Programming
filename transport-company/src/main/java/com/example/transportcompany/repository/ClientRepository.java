package com.example.transportcompany.repository;

import com.example.transportcompany.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {
}
