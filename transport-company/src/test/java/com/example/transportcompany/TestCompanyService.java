package com.example.transportcompany;

import com.example.transportcompany.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertWith;

@SpringBootTest
public class TestCompanyService extends AbstractServiceTest {

    private final String COMPANY_NAME = "KARAT C";

    @Test
    void create() {
        companyService.save(new Company(COMPANY_NAME));
        Optional<Company> company = companyService.getById(COMPANY_NAME);
        assertThat(company).isPresent();
    }

    @Test
    void read() {
        companyService.save(new Company(COMPANY_NAME));
        companyService.save(new Company("Company 2"));
        assertThat(companyService.getById(COMPANY_NAME)).isPresent();
        assertThat(companyService.getAll().size()).isEqualTo(2);
    }

    @Test
    void update() {
        Company company = new Company(COMPANY_NAME, "Street 1");
        companyService.save(company);
        company.setAddress("Street 2");
        companyService.update(company);
        assertWith(companyService.getById(COMPANY_NAME), company1 -> {
            assertThat(company1).isPresent();
            assertThat(company1.get().getAddress()).isEqualTo("Street 2");
        });
    }

    @Test
    void delete() {
        companyService.save(new Company(COMPANY_NAME));
        companyService.deleteByID(COMPANY_NAME);
        assertThat(companyService.getById(COMPANY_NAME)).isEmpty();
    }
}
