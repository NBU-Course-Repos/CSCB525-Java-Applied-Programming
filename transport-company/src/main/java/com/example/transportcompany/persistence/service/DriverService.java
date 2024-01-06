package com.example.transportcompany.persistence.service;

import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Driver;
import com.example.transportcompany.persistence.model.Specialisation;
import com.example.transportcompany.persistence.repository.CompanyRepository;
import com.example.transportcompany.persistence.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Service to be used for any CRUD operation, as well as necessary transformations,
 * to {@link DriverRepository}
 */
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

    public List<Driver> getAllDriversWithEmployer(Company company) {
        return repository.findAllByEmployer(company);
    }
}
