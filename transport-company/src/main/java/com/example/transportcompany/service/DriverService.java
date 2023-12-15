package com.example.transportcompany.service;

import com.example.transportcompany.model.Driver;
import com.example.transportcompany.model.Specialisation;
import com.example.transportcompany.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class DriverService extends AbstractService<Driver, UUID, DriverRepository> {
    @Override
    UUID getId(Driver entity) {
        return entity.getUCN();
    }

    public List<Driver> orderBySpecialisationAndWage() {
        return repository.findAllByOrderBySpecialisationsAscWageAsc();
    }

    public List<Driver> findBySpecialisations(List<Specialisation> specialisations) {
        return repository.findAllBySpecialisationsIn(specialisations);
    }

    public List<Driver> findByWageInRange(BigDecimal lowerBound, BigDecimal topBound) {
        return repository.findAllByWageBetween(lowerBound, topBound);
    }
}
