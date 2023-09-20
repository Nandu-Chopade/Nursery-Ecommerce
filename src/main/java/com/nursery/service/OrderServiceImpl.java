package com.nursery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.model.Order;
import com.nursery.model.User;
import com.nursery.repository.OrderRepository;
import com.nursery.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Order> getUserOrders(Long id) {
		User user = userRepository.findById(id).get();
		Long UserId = user.getId();
		return  orderRepository.findByUserId(UserId);
	}

	@Override
	public Order getOrderById(Long orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public Order createOrder(Order order) {
		return  orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

}
