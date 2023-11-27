package com.example.transportcompany.service;

import com.example.transportcompany.model.Company;
import com.example.transportcompany.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractService<Company, String, CompanyRepository> {
    @Override
    String getId(Company entity) {
        return entity.getName();
    }
}
