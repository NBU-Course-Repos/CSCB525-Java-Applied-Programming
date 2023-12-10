package com.example.transportcompany;

import com.example.transportcompany.model.Company;
import com.example.transportcompany.model.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestDriverService extends AbstractServiceTest {

    @Test
    void create() {
        assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() ->
                        driverService.save(new Driver()))
                .withMessageContaining("not-null property references a null or transient value");

        Company company = companyService.save(new Company("asdfs"));

        Driver driver = driverService.save(new Driver("Ivan", "Ivanov", company));
        assertThat(driver.getUCN()).isNotNull();
    }

    @Test
    void read() {
        Driver driver = driverService.save(new Driver(
                "Ivan",
                "Ivanov",
                companyService.save(new Company("asdfs"))
        ));

        Driver driver2 = driverService.save(new Driver(
                "Petar",
                "Petrov",
                driver.getEmployer()
        ));
        
        assertThat(driverService.getById(driver.getUCN())).isPresent();
        assertThat(driverService.getAll().size()).isEqualTo(2);
    }

    @Test
    void update() {
        Driver driver = driverService.save(new Driver(
                "Ivan",
                "Ivanov",
                companyService.save(new Company("asdfs"))
        ));
        driver.setLastName("Petrov");
        driverService.update(driver);
        Optional<Driver> updatedDriver = driverService.getById(driver.getUCN());
        assertThat(updatedDriver).isPresent();
        assertThat(updatedDriver.get().getLastName()).isEqualTo("Petrov");
    }

    @Test
    void delete() {
        Driver driver = driverService.save(new Driver(
                "Ivan",
                "Ivanov",
                companyService.save(new Company("asdfs"))
        ));
        assertThat(driverService.getById(driver.getUCN())).isPresent();

        driverService.deleteByID(driver.getUCN());
        assertThat(driverService.getById(driver.getUCN())).isEmpty();
    }
}
