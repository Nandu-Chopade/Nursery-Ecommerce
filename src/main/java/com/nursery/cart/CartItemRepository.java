package com.nursery.cart;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // You can add custom query methods here if needed
}
