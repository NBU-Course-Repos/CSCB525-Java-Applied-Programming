package com.example.transportcompany;

import com.example.transportcompany.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
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

    @Test
    void orderAndFiltering() {

        Company company1 = companyService.save(new Company("ABC", "Sofia", BigDecimal.valueOf(2000)));
        Company company2 = companyService.save(new Company("BAC", "Sofia", BigDecimal.valueOf(1100)));
        Company company3 = companyService.save(new Company("BCA", "Sofia", BigDecimal.valueOf(900)));

        List<Company> filtered1 = companyService.findComapnyWithEarnings(BigDecimal.valueOf(1900), BigDecimal.valueOf(2000));
        assertThat(filtered1).hasSize(1);
        assertThat(filtered1.stream().map(Company::getName).toList())
                .containsExactly(company1.getName());

        List<Company> filtered2 = companyService.getOrderedByNameAndEarnings();
        assertThat(filtered2).hasSize(3);
        assertThat(filtered2.stream().map(Company::getName))
                .containsExactly(company1.getName(), company2.getName(), company3.getName());


        List<Company> filtered3 = companyService.findComapnyWithEarnings(BigDecimal.valueOf(0), BigDecimal.valueOf(1110));
        assertThat(filtered3).hasSize(2);
        assertThat(filtered3.stream().map(Company::getName).toList())
                .containsExactly(company2.getName(), company3.getName());

        List<Company> filtered4 = companyService.findComapnyWithEarnings(BigDecimal.valueOf(10000), BigDecimal.valueOf(321321));
        assertThat(filtered4).isEmpty();
    }
}
