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
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateJob(@PathVariable Long id, @RequestBody Company updateCompany ){
       boolean updated= companyService.updateCompany(id, updateCompany);
        if(updated){
            return new ResponseEntity<>("Updated the job", HttpStatus.OK);
        }
        return new ResponseEntity<>("Updation failer", HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanybyId(@PathVariable Long id){
        boolean deleted=companyService.deleteCompanyById(id);
        if(deleted){
            return new ResponseEntity<>("Deleted the company", HttpStatus.OK);
        }
        return new ResponseEntity<>("Deletion failed",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id){
        Company company=companyService.findCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
