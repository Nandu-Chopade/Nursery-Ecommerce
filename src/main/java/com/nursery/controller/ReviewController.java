package com.nursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.model.Review;
import com.nursery.service.ReviewServiceImpl;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
    private ReviewServiceImpl reviewServiceImpl;

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewServiceImpl.createReview(review);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewServiceImpl.getReviewById(id);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewServiceImpl.getAllReviews();
    }

}
