package com.nursery.service;

import java.util.List;

import com.nursery.model.Review;

public interface ReviewService {

    Review createReview(Review review);

    List<Review> getAllReviews();

    Review getReviewById(Long id);

    // Add method signatures for updating and deleting reviews as needed
}
