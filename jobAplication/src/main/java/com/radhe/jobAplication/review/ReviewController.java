package com.radhe.jobAplication.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        List<Review> reviews = reviewService.getAllReviews(companyId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/reviews/{reviewId}")
    public  ResponseEntity<Review> getReviewBYId(@PathVariable Long reviewId){
        Review review = reviewService.getReviewById(reviewId);
        if(review==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(review);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        if(reviewService.createReview(companyId,review)){
            return ResponseEntity.ok("Review created successfully.");
        }
        return new ResponseEntity<>("cannot create review, since does not exist.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review){

        if(reviewService.updateReview(reviewId, review)){
            return ResponseEntity.ok("Review updated successfully.");
        }
        return new ResponseEntity<>("review with "+ reviewId+ " does not exists.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){

        if(reviewService.deleteReview(reviewId)){
            return ResponseEntity.ok("Review with id "+ reviewId + " deleted successfully");
        }
        return new ResponseEntity<>("review with "+ reviewId+ " does not exists.", HttpStatus.NOT_FOUND);
    }
}
