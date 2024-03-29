package com.example.transportcompany.reports;

import com.example.transportcompany.dto.CompanyDTO;
import com.example.transportcompany.dto.DriverDTO;
import com.example.transportcompany.persistence.model.Company;

import java.util.List;

/**
 * An abstraction of a {@link Company} report.
 */
public class Report {

    private CompanyDTO companyInfo;

    private List<DriverDTO> driversInfo;

    public Report(CompanyDTO companyInfo, List<DriverDTO> drivers) {
        this.companyInfo = companyInfo;
        this.driversInfo = drivers;
    }

    public Report() {
    }

    public CompanyDTO getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyDTO companyInfo) {
        this.companyInfo = companyInfo;
    }

    public List<DriverDTO> getDriversInfo() {
        return driversInfo;
    }

    public void setDriversInfo(List<DriverDTO> driversInfo) {
        this.driversInfo = driversInfo;
    }
}