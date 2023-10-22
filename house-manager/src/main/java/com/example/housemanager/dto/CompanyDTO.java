package com.example.housemanager.dto;

import com.example.housemanager.persistence.model.BuildingManager;
import com.example.housemanager.persistence.model.Company;

import java.util.List;

public class CompanyDTO extends AbstractDTO<Company> {

    public String name;

    public List<BuildingManagerDTO> managers;

    public Company toEntity() {
        return new Company();
    }
}
