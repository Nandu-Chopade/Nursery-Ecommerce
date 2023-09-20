package com.nursery.controller;

import com.nursery.dto.ReviewDTO;
import com.nursery.model.Review;
import com.nursery.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/users/{userId}/products/{productId}")
    public ResponseEntity<String> createReview(@RequestBody Review review, @PathVariable Long userId, @PathVariable Long productId) {
        Review createdReview = reviewService.createReview(review, userId, productId);
        return ResponseEntity.ok("Review submitted successfully with ID: " + createdReview.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        ReviewDTO reviewDTO = reviewService.getReviewById(id);
        return reviewDTO != null ? ResponseEntity.ok(reviewDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        List<ReviewDTO> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }
}
