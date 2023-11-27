package com.example.transportcompany.repository;

import com.example.transportcompany.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
}
