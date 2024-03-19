package com.radhe.jobAplication.job.imp;

import com.radhe.jobAplication.company.Company;
import com.radhe.jobAplication.company.CompanyRepository;
import com.radhe.jobAplication.company.CompanyService;
import com.radhe.jobAplication.job.Job;
import com.radhe.jobAplication.job.JobRepository;
import com.radhe.jobAplication.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp  implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(null);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        if(jobRepository.findById(id).isPresent()) {
            jobRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean updateJobBYId(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }
        return false;
    }

}
