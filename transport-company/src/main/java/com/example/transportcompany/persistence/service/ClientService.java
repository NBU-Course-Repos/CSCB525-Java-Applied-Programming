package com.example.transportcompany.persistence.service;

import com.example.transportcompany.persistence.model.Client;
import com.example.transportcompany.persistence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service to be used for any CRUD operation, as well as necessary transformations,
 * to {@link ClientRepository}
 */
@Service
public class ClientService extends AbstractService<Client, UUID, ClientRepository> {

    @Override
    UUID getId(Client entity) {
        return entity.getClientId();
    }
}
