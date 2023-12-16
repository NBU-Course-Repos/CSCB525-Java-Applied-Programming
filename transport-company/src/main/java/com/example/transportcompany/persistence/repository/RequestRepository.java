package com.example.transportcompany.persistence.repository;

import com.example.transportcompany.persistence.model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

    List<Request> findAllByOrderByDestinationAsc();

    List<Request> findAllByDestinationContaining(String destination);
}
