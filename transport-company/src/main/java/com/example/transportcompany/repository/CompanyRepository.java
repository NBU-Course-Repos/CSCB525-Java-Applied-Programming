package com.example.transportcompany.repository;

import com.example.transportcompany.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {

    List<Company> findAllByOrderByNameAscEarningsAsc();

    List<Company> findAllByOrderByNameAsc();

    List<Company> findAllByOrderByEarningsAsc();

    List<Company> findAllByEarningsBetween(BigDecimal lowerBound, BigDecimal topBound);
}
