package com.aanchal.JobApplication.Company.Impl;

import com.aanchal.JobApplication.Company.Company;
import com.aanchal.JobApplication.Company.CompanyRepository;
import com.aanchal.JobApplication.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class companyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public companyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();

    }

}
