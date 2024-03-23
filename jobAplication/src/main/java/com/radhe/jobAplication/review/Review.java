package com.radhe.jobAplication.review;

import com.radhe.jobAplication.company.Company;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String title;
    private String description;
    private double rating;

    @ManyToOne
    private Company company;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Review() {
    }

    public Review(Long reviewId, String title, String description, double rating) {
        this.reviewId = reviewId;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }
}
