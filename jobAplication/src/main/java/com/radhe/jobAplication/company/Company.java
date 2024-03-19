package com.radhe.jobAplication.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.radhe.jobAplication.job.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private int totalEmployee;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTotalEmployee() {
        return totalEmployee;
    }

    public void setTotalEmployee(int totalEmployee) {
        this.totalEmployee = totalEmployee;
    }

    public Company(Long id, String companyName, int totalEmployee) {
        this.companyName = companyName;
        this.totalEmployee = totalEmployee;
    }
}
