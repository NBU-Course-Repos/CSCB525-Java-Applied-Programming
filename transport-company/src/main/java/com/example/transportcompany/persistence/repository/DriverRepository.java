package com.example.transportcompany.persistence.repository;

import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Driver;
import com.example.transportcompany.persistence.model.Specialisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRepository extends CrudRepository<Driver, UUID> {

    List<Driver> findAllByOrderBySpecialisationsAscWageAsc();

    List<Driver> findAllBySpecialisationsIn(List<Specialisation> specialisations);

    List<Driver> findAllByWageBetween(BigDecimal lowerBound, BigDecimal topBound);

    List<Driver> findAllByEmployer(Company company);
}
