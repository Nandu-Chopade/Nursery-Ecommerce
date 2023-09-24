package com.nursery.order.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetails createOrder(OrderDetails orderDetails) {
        // Set createdAt and modifiedAt timestamps
        orderDetails.setCreatedAt(LocalDateTime.now());
        orderDetails.setModifiedAt(LocalDateTime.now());

        // Perform any additional logic or validation here

        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails getOrderById(Long orderId) {
        return orderDetailsRepository.findById(orderId).orElse(null);
    }

    // Implement other service methods
}
