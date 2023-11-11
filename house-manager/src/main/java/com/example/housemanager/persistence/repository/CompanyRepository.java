package com.example.housemanager.persistence.repository;

import com.example.housemanager.persistence.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
}