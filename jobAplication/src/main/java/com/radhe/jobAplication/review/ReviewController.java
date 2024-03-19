package com.radhe.jobAplication.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

//    @Autowired
    ReviewService reviewService;

//    @GetMapping
//    public ResponseEntity<List<Review>> getAllReviews(){
//        reviewService.getAllReviews();
//    }
}
