package com.nursery.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nursery.com/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/users/{userId}/products/{productId}") 
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
    public ResponseEntity<String> createReview(@RequestBody Review review, @PathVariable Long userId, @PathVariable Long productId) {
        Review createdReview = reviewService.createReview(review, userId, productId);
        return ResponseEntity.ok("Review submitted successfully with ID: " + createdReview.getId());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        ReviewDTO reviewDTO = reviewService.getReviewById(id);
        return reviewDTO != null ? ResponseEntity.ok(reviewDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        List<ReviewDTO> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }
}
