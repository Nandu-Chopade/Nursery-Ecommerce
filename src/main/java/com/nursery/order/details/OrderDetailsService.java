package com.nursery.order.details;

public interface OrderDetailsService {
    OrderDetails createOrder(OrderDetails orderDetails);

    OrderDetails getOrderById(Long orderId);

    // Add other service methods as needed
}
