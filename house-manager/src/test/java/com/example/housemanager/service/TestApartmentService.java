package com.example.housemanager.service;

import com.example.housemanager.AbstractTest;
import com.example.housemanager.persistence.model.Apartment;
import com.example.housemanager.persistence.repository.ApartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApartmentService extends AbstractTest {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    void saveApartment() {
        Apartment apartment = prepareApartment();
        assert (apartmentService.findById(apartment.getId()).isPresent());
    }

    @Test
    void deleteApartment() {
        Apartment apartment = prepareApartment();
        apartmentRepository.deleteById(apartment.getId());
        assert (apartmentService.findById(apartment.getId()).isEmpty());
    }

    @Test
    void updateApartment() {
        Apartment apartment = prepareApartment();
        String previousOwner = apartment.getOwner();
        String newOwner = "Atanas Atanasov";
        apartment.setOwner(newOwner);
        apartmentService.update(apartment);

        assert (apartmentService.findById(apartment.getId()).isPresent());
        assert (apartmentService.findById(apartment.getId()).get().getOwner().equals(newOwner));
    }
}
