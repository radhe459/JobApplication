package com.radhe.jobAplication.review.imp;

import com.radhe.jobAplication.company.Company;
import com.radhe.jobAplication.company.CompanyRepository;
import com.radhe.jobAplication.company.CompanyService;
import com.radhe.jobAplication.review.Review;
import com.radhe.jobAplication.review.ReviewRepository;
import com.radhe.jobAplication.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CompanyService companyService;
    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean createReview(Long companyId,Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, Review review) {
        Review reviewFromDb = reviewRepository.findById(reviewId).orElse(null);
        if(reviewFromDb!=null){
            review.setReviewId(reviewId);
            review.setCompany(reviewFromDb.getCompany());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview( Long reviewId) {
        if(reviewRepository.existsById(reviewId)){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
