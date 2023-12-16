package com.example.transportcompany.persistence;

import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Driver;
import com.example.transportcompany.persistence.model.Specialisation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Test
    void filterAndSearch() {
        Company company = companyService.save(new Company("Speedy"));

        Driver driver1 = driverService.save(new Driver("A", "B", company, BigDecimal.valueOf(10),
                Set.of(Specialisation.DEFAULT)));
        Driver driver2 = driverService.save(new Driver("A", "B", company, BigDecimal.valueOf(1),
                Set.of(Specialisation.FLAMMABLE, Specialisation.COMMERCIAL)));
        Driver driver3 = driverService.save(new Driver("A", "B", company, BigDecimal.valueOf(2),
                Set.of(Specialisation.COMMERCIAL)));

        List<Driver> filtered1 = driverService.findBySpecialisations(List.of(Specialisation.COMMERCIAL));
        assertThat(filtered1).hasSize(2);
        assertThat(filtered1.stream().map(Driver::getUCN)).containsExactlyInAnyOrder(driver2.getUCN(), driver3.getUCN());

        List<Driver> filtered2 = driverService.findBySpecialisations(List.of(Specialisation.FLAMMABLE));
        assertThat(filtered2).hasSize(1);
        assertThat(filtered2.stream().map(Driver::getUCN)).containsExactlyInAnyOrder(driver2.getUCN());

        List<Driver> filtered3 = driverService.findByWageInRange(BigDecimal.valueOf(0), BigDecimal.valueOf(1));
        assertThat(filtered3).hasSize(1);
        assertThat(filtered3.stream().map(Driver::getUCN)).containsExactly(driver2.getUCN());
    }
}
