package com.nursery.shipping;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ShippingSessionRepository extends JpaRepository<ShippingSession, Long> {
	 Optional<ShippingSession> findByUserId(Long userId);
}
