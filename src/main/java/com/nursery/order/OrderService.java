package com.nursery.order;

import java.util.List;

public interface OrderService {

	//    Order createOrder(Long userId, List<OrderItem> orderItems);

	List<OrderDTO> getUserOrders(Long id);

	OrderDTO getOrderById(Long orderId);
	 Order getOrderByIds(Long orderId);
	 Order createOrder(Order order);
	
	List<OrderDTO> getAllOrders();
}