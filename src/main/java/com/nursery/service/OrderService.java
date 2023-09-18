package com.nursery.service;

import java.util.List;

import com.nursery.model.Order;

public interface OrderService {

	//    Order createOrder(Long userId, List<OrderItem> orderItems);

    List<Order> getUserOrders(Long userId);

    Order getOrderById(Long orderId);

	Order createOrder(Order order);
	
	public List<Order> getAllOrders();
}