package com.example.transportcompany.service;

import com.example.transportcompany.model.Driver;
import com.example.transportcompany.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DriverService extends AbstractService<Driver, UUID, DriverRepository> {
    @Override
    UUID getId(Driver entity) {
        return entity.getUCN();
    }
}
