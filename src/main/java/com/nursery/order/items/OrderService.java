package com.nursery.order.items;

import java.util.List;

public interface OrderService {

	//    Order createOrder(Long userId, List<OrderItem> orderItems);

	List<OrderItemDTO> getUserOrders(Long id);

	OrderItemDTO getOrderById(Long orderId);
	OrderItems placeYourOrder(OrderItems order , Long productId , Long userId);
//	 OrderItems createOrder(OrderItems order);
	
	List<OrderItemDTO> getAllOrders();
}