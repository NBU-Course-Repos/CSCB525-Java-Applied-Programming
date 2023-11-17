package com.example.housemanager.persistence.repository;

import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.Company;
import com.example.housemanager.persistence.model.composite.BuildingManagerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingManagerRepository extends CrudRepository<BuildingManager, BuildingManagerId> {

    BuildingManager findFirstByIdNotAndId_CompanyOrderByManagedBuildingsAsc(BuildingManagerId id, Company company);
    //TODO Test when deleting Manager and when his buildings are re-distributed equality amongst other managers
}
