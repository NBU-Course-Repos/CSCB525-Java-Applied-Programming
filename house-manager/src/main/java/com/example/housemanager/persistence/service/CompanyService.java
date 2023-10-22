package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.model.Company;
import com.example.housemanager.persistence.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractEntityService<Company, CompanyRepository> {

    @Override
    protected String getEntityId(Company company) {
        return company.getName();
    }
}
