package com.nursery.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	 List<CartItem> findBySessionId(Long shippingSessionId);
}
