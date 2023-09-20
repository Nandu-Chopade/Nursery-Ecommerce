package com.nursery.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.dto.OrderDTO;
import com.nursery.dto.UserDTO;
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
	
	public List<OrderDTO> getUserOrders(Long id) {
	    User user = userRepository.findById(id).orElse(null);
	    
	    if (user == null) {
	        // Handle the case where the user is not found
	        return Collections.emptyList(); // Or throw an exception
	    }

	    List<Order> userOrders = orderRepository.findByUserId(user.getId());

	    // Map Order entities to OrderDTO objects
	    List<OrderDTO> orderDTOs = userOrders.stream()
	            .map(order -> {
	                OrderDTO orderDTO = new OrderDTO();
	                orderDTO.setId(order.getId());
	                orderDTO.setOrderDate(order.getOrderDate());
	                return orderDTO;
	            })
	            .collect(Collectors.toList());

	    return orderDTOs;
	}


	@Override
	public OrderDTO getOrderById(Long orderId) {
		return orderRepository.findById(orderId).map(order -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setOrderDate(order.getOrderDate());
            return orderDTO;
        }).orElse(null);
		
		//TODO: work on null
	}

	@Override
	public Order createOrder(Order order) {
		return  orderRepository.save(order);
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		 return orderRepository.findAll().stream()
		            .map(order -> {
		                OrderDTO orderDTO = new OrderDTO();
		                orderDTO.setId(order.getId());
		                orderDTO.setOrderDate(order.getOrderDate());
		                return orderDTO;
		            })
		            .collect(Collectors.toList());
	}

}
