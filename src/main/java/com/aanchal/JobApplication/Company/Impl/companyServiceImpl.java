package com.aanchal.JobApplication.Company.Impl;

import com.aanchal.JobApplication.Company.Company;
import com.aanchal.JobApplication.Company.CompanyRepository;
import com.aanchal.JobApplication.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class companyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public companyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();

    }

    @Override
    public boolean updateCompany(Long id, Company updatedcompany) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyToUpdate=companyOptional.get();
            companyToUpdate.setName(updatedcompany.getName());
            companyToUpdate.setJobs(updatedcompany.getJobs());
            companyToUpdate.setDescription(updatedcompany.getDescription());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    public void createCompany(Company company){
        companyRepository.save(company);
    }

}
