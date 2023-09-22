package com.nursery.shipping;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ShippingSessionRepository extends JpaRepository<ShippingSession, Long> {
    // You can define custom query methods here if needed
}
