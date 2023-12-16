package com.example.transportcompany.persistence.service;

import com.example.transportcompany.persistence.model.Vehicle;
import com.example.transportcompany.persistence.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleService extends AbstractService<Vehicle, UUID, VehicleRepository> {

    @Override
    UUID getId(Vehicle entity) {
        return entity.getVehicleNumber();
    }
}
