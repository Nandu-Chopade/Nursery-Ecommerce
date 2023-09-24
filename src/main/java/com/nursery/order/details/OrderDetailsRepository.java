package com.nursery.order.details;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    // Add custom query methods if needed
}
