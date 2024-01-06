package com.example.transportcompany.persistence.service;

import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.repository.ClientRepository;
import com.example.transportcompany.persistence.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service to be used for any CRUD operation, as well as necessary transformations,
 * to {@link CompanyRepository}
 */
@Service
public class CompanyService extends AbstractService<Company, String, CompanyRepository> {
    @Override
    String getId(Company entity) {
        return entity.getName();
    }

    public void addToEarnings(Company company, BigDecimal amount) {
        company.setEarnings(company.getEarnings().add(amount));
        update(company);
    }

    public List<Company> getOrderedByNameAndEarnings() {
        return repository.findAllByOrderByNameAscEarningsAsc();
    }

    public List<Company> findComapnyWithEarnings(BigDecimal lowerBound, BigDecimal topBound) {
        return repository.findAllByEarningsBetween(lowerBound, topBound);
    }
}
