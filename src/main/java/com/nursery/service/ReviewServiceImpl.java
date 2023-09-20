package com.nursery.service;

import com.nursery.dto.ReviewDTO;
import com.nursery.model.Product;
import com.nursery.model.Review;
import com.nursery.model.User;
import com.nursery.repository.ProductRepository;
import com.nursery.repository.ReviewRepository;
import com.nursery.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Review createReview(Review review, Long userId, Long productId) {
        User user = userRepository.findById(userId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (user == null || product == null) {
            // Handle user or product not found cases
            throw new IllegalArgumentException("User or product not found");
        }

        if (hasUserReviewedProduct(user.getId(), product.getId())) {
            // User has already reviewed the product, return an error message or handle it as needed
            throw new IllegalArgumentException("You have already reviewed this product.");
        }

        review.setUser(user);
        review.setProduct(product);
        review.setCreatedAt(new Date());
        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();

        return reviews.stream().map(review -> {
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setId(review.getId());
            reviewDTO.setComment(review.getComment());
            reviewDTO.setRating(review.getRating());
            reviewDTO.setCreatedAt(review.getCreatedAt());
            return reviewDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        return reviewRepository.findById(id)
                .map(review -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setId(review.getId());
                    reviewDTO.setComment(review.getComment());
                    reviewDTO.setRating(review.getRating());
                    reviewDTO.setCreatedAt(review.getCreatedAt());
                    return reviewDTO;
                })
                .orElse(null);
    }

    private boolean hasUserReviewedProduct(Long userId, Long productId) {
        return reviewRepository.existsByUserIdAndProductId(userId, productId);
    }

}
