package com.nursery.order.items;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderItems, Long> {
	 
//	List<OrderItems> findByUserId(Long userId);
}