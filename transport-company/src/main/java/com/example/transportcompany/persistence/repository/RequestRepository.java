package com.example.transportcompany.persistence.repository;

import com.example.transportcompany.persistence.model.Company;
import com.example.transportcompany.persistence.model.Driver;
import com.example.transportcompany.persistence.model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

    List<Request> findAllByOrderByDestinationAsc();

    List<Request> findAllByDestinationContaining(String destination);

    Long countByCompany(Company company);

    Integer countByDriver(Driver driver);

    List<Request> findAllByDriverAndDepartureDateBetween(Driver driver, Date startDate, Date endDate);

    List<Request> findAllByCompanyAndDepartureDateBetween(Company company, Date startDate, Date endDate);
}
