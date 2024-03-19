package com.radhe.jobAplication.company.imp;

import com.radhe.jobAplication.company.Company;
import com.radhe.jobAplication.company.CompanyRepository;
import com.radhe.jobAplication.company.CompanyService;
import com.radhe.jobAplication.job.Job;
import com.radhe.jobAplication.job.JobRepository;
import com.radhe.jobAplication.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    JobService jobService;


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void addCompany(Company company) {
        company.setId(null);
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompanyById(Long id, Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setCompanyName(updatedCompany.getCompanyName());
            company.setTotalEmployee(updatedCompany.getTotalEmployee());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            List<Job> jobs= companyRepository.findById(id).get().getJobs();
            if(jobs!=null){
                for (Job job:jobs){
                    jobService.deleteJobById(job.getId());
                }
            }
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
