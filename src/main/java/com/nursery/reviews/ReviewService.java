package com.nursery.reviews;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review, Long userId, Long productId);
    List<ReviewDTO> getAllReviews();
    ReviewDTO getReviewById(Long id);
}
