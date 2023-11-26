package com.example.transportcompany.repository;

import com.example.transportcompany.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, String> {
}
