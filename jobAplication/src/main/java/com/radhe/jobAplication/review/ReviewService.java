package com.radhe.jobAplication.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    Review getReviewById(Long reviewId);

    boolean createReview(Long companyId,Review review);

    boolean updateReview(Long companyId, Review review);

    boolean deleteReview(Long reviewId);
}
