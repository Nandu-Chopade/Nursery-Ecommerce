package com.nursery.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	 boolean existsByUserIdAndProductId(Long user_id , Long product_id);
}
