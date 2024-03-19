package com.radhe.jobAplication.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();

    Review getReviewById(Long reviewId);

    boolean createReview(Long companyId);

    boolean updateReview(Long companyId, Long reviewId);

    boolean deleteReview(Long companyId,Long reviewId);
}
