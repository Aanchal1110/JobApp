package com.aanchal.JobApplication.Reviews;

import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/")
public class ReviewsController {

    ReviewsService reviewService;

    public ReviewsController(ReviewsService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> GetAllReviews(@PathVariable Long companyId){
        List<Reviews> reviews = reviewService.getAllReviews(companyId);

        if (reviews == null || reviews.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);

    }
    @PostMapping("/reviews")
    public ResponseEntity<String> createReviews(@PathVariable Long companyId, @RequestBody Reviews review){
        boolean isCreated=reviewService.createReview(companyId,review);
        if(isCreated){
            return new ResponseEntity<>("Review created",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review could not be created",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }
}
