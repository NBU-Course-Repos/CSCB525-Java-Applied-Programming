package com.example.transportcompany.persistence;

import com.example.transportcompany.AbstractTest;
import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Vehicle;
import com.example.transportcompany.persistence.model.VehicleType;
import com.example.transportcompany.persistence.service.DriverService;
import com.example.transportcompany.persistence.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.*;

/**
 * A class that defines the necessary tests for {@link VehicleService}
 */
public class TestVehicleService extends AbstractTest implements ModelServiceTest {
    @Test
    public void create() {
        assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() ->
                        vehicleService.save(new Vehicle()))
                .withMessageContaining("not-null property references a null or transient value");

        Vehicle vehicle = vehicleService.save(
                new Vehicle(
                        VehicleType.BUS,
                        companyService.save(new Company("asdfs"))
                )
        );
        Vehicle vehicle2 = vehicleService.save(
                new Vehicle(
                        VehicleType.BUS,
                        companyService.save(new Company("asdfs"))
                )
        );

        assertThat(vehicle.getVehicleNumber()).isNotNull();
        assertThat(vehicle.getVehicleNumber()).isNotEqualTo(vehicle2.getVehicleNumber());
    }

    @Test
    public void read() {
        Vehicle vehicle = vehicleService.save(
                new Vehicle(
                        VehicleType.BUS,
                        companyService.save(new Company("asdfs"))
                )
        );
        Vehicle vehicle2 = vehicleService.save(
                new Vehicle(
                        VehicleType.BUS,
                        companyService.save(new Company("asdfs"))
                )
        );

        assertThat(vehicleService.getAll().size()).isEqualTo(2);
        assertThat(vehicleService.getById(vehicle.getVehicleNumber())).isPresent();
    }

    @Test
    public void update() {
        Vehicle vehicle = vehicleService.save(
                new Vehicle(
                        VehicleType.BUS,
                        companyService.save(new Company("asdfs"))
                )
        );
        assertThat(vehicleService.getById(vehicle.getVehicleNumber()).get().getDriver()).isNull();
        vehicle.setOwner(companyService.save(new Company("UBER")));

        vehicleService.update(vehicle);

        assertThat(vehicleService.getById(vehicle.getVehicleNumber()).get().getOwner().getName()).isEqualTo("UBER");
    }

    @Test
    public void delete() {
        Vehicle vehicle = vehicleService.save(
                new Vehicle(
                        VehicleType.BUS,
                        companyService.save(new Company("asdfs"))
                )
        );
        assertThat(vehicleService.getById(vehicle.getVehicleNumber())).isPresent();

        vehicleService.delete(vehicle);
        assertThat(vehicleService.getById(vehicle.getVehicleNumber())).isEmpty();
    }
}
