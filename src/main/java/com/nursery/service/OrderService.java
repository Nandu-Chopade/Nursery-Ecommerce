package com.nursery.service;

import java.util.List;

import com.nursery.dto.OrderDTO;
import com.nursery.model.Order;

public interface OrderService {

	//    Order createOrder(Long userId, List<OrderItem> orderItems);

	List<OrderDTO> getUserOrders(Long id);

	OrderDTO getOrderById(Long orderId);

	Order createOrder(Order order);
	
	List<OrderDTO> getAllOrders();
}