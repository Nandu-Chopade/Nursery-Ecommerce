package com.nursery.order;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.product.model.Product;
import com.nursery.product.repository.ProductRepository;
import com.nursery.user.model.User;
import com.nursery.user.repository.UserRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
    private OrderService orderService;

	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
    private UserRepository userRepository;

    // Create a new order
    @PostMapping("/products/{productId}/user/{userId}")
    public Order createOrder(@RequestBody Order order , @PathVariable Long productId , @PathVariable Long userId) {
    	// Fetch the product and user entities
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        // Set the user and product in the order
        order.setUser(user);
        order.setProducts(Collections.singletonList(product));

    	return orderService.createOrder(order);
    }

    // Retrieve a specific order by ID
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Retrieve a list of all orders
    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Add more methods for updating and deleting orders as needed
}
