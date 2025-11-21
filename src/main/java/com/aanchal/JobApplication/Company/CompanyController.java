package com.aanchal.JobApplication.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {

        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping("{id}")
    public ResponseEntity<String> UpdateJob(@PathVariable Long id, @RequestBody Company updateCompany ){
        companyService.updateCompany(id, updateCompany);
        return new ResponseEntity<>("Updated the job", HttpStatus.OK);
    }
}
