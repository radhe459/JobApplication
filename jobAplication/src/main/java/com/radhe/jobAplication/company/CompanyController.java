package com.radhe.jobAplication.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @GetMapping
    public ResponseEntity<List<Company>>getCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyBYId(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        return company!=null ? ResponseEntity.ok(company): new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody  Company company){
        companyService.addCompany(company);
        return ResponseEntity.ok("Company added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        if(companyService.updateCompanyById(id,company)){
            return ResponseEntity.ok("Company with id "+ id+" updated successfully");
        }
        return new ResponseEntity<>("Company with id "+ id+" does not exist.",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        if(companyService.deleteCompanyById(id)){
            return ResponseEntity.ok("Company with id "+ id+" deleted successfully");
        }
        return new ResponseEntity<>("Company with id "+ id+" does not exist.",HttpStatus.NOT_FOUND);
    }


}
