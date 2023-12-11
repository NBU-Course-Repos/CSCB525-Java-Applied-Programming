package com.example.transportcompany;

import com.example.transportcompany.model.Company;
import com.example.transportcompany.model.Vehicle;
import com.example.transportcompany.model.VehicleType;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.*;

public class TestVehicleService extends AbstractServiceTest {
    @Test
    void create() {
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
    void read() {
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
    void update() {
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
    void delete() {
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
