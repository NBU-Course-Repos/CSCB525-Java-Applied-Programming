package com.example.transportcompany.persistence.repository;

import com.example.transportcompany.persistence.model.Client;
import com.example.transportcompany.persistence.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * CRUD repository for {@link Company} model
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {

    List<Company> findAllByOrderByNameAscEarningsAsc();

    List<Company> findAllByOrderByNameAsc();

    List<Company> findAllByOrderByEarningsAsc();

    List<Company> findAllByEarningsBetween(BigDecimal lowerBound, BigDecimal topBound);
}
