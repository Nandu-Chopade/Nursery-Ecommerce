package com.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nursery.model.Review;
import com.nursery.model.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Add custom query methods if needed
}
