package com.example.housemanager.service;

import com.example.housemanager.AbstractTest;
import com.example.housemanager.persistence.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
public class TestCompanyService extends AbstractTest {

    @Test
    void saveCompany() {
        Company company = prepareCompany();

        assert (companyService.findById(company.getId()).isPresent());
        assert (companyService.findById(company.getId()).get().getName().equals("Company"));
    }

    @Test
    void findAll() {
        for (int i = 1; i != 10; i++)
            companyService.save(new Company("company" + i));
        Iterator<Company> companies = companyService.findAll().iterator();
        assert (companies.next().getName().equals("company1"));
        assert (companies.next().getName().equals("company2"));
    }

    @Test
    void deleteCompany() {
        Company company = prepareCompany();
        assert (companyService.findById(company.getId()).isPresent());

        companyService.delete(company);
        assert (companyService.findById(company.getId()).isEmpty());
    }

    @Test
    void updateCompany() {
        Company company = prepareCompany();
        assert (company.getName().equals("Company"));

        company.setName("Company2");
        companyService.update(company);
        assert (companyService.findById(company.getId())).isPresent();
        assert (companyService.findById(company.getId()).get().getName().equals("Company2"));
    }
}
