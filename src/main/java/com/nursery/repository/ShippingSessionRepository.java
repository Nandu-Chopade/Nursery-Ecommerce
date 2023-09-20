package com.nursery.repository;

import com.nursery.model.ShippingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingSessionRepository extends JpaRepository<ShippingSession, Long> {
    // You can define custom query methods here if needed
}
