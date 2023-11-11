package com.example.housemanager.service;

import com.example.housemanager.AbstractTest;
import com.example.housemanager.persistence.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.Optional;

@SpringBootTest
public class TestCompanyService extends AbstractTest {

    @Test
    void saveCompany() {
        final String companyName = "company1";
        companyService.save(new Company(companyName));
        Optional<Company> company = companyService.findById(companyName);
        assert (company.isPresent());
        assert (company.get().getName().equals(companyName));
    }

    @Test
    void findAll() {
        for (int i = 1; i != 10; i++)
            companyService.save(new Company("company" + i));
        Iterator<Company> companies = companyService.findAll().iterator();
        assert (companies.next().getName().equals("company1"));
        assert (companies.next().getName().equals("company2"));
    }
}
