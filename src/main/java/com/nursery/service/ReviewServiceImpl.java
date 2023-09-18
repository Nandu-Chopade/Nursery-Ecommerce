package com.nursery.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.dao.ReviewRepository;
import com.nursery.model.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private  ReviewRepository reviewRepository;

	
    public Review createReview(Review review) {
        review.setCreatedAt(new Date()); // Set the creation timestamp
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // Add methods for updating and deleting reviews as needed
}
