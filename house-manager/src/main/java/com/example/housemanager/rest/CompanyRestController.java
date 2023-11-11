package com.example.housemanager.rest;

import com.example.housemanager.persistence.model.Company;
import com.example.housemanager.persistence.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    void createCompany(String name) {
        companyService.save(new Company(name));
    }

    @GetMapping("/{id}")
    Optional<Company> getCompanyById(@PathVariable String id) {
        return companyService.findById(id);
    }
}
