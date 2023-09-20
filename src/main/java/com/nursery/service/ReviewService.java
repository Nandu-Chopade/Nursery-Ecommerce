package com.nursery.service;

import com.nursery.dto.ReviewDTO;
import com.nursery.model.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review, Long userId, Long productId);
    List<ReviewDTO> getAllReviews();
    ReviewDTO getReviewById(Long id);
}
