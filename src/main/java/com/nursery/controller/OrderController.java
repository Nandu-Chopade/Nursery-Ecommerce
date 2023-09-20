package com.nursery.controller;

import com.nursery.model.Order;
import com.nursery.model.Product;
import com.nursery.repository.ProductRepository;
import com.nursery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
    private OrderService orderService;

	@Autowired
    private ProductRepository productRepository;

    // Create a new order
    @PostMapping("/products/{productId}")
    public Order createOrder(@RequestBody Order order , @PathVariable Long ProductId) {
        List<Product> product = productRepository.findById(ProductId).stream().collect(Collectors.toList());
        order.setProducts(product);
    	return orderService.createOrder(order);
    }

    // Retrieve a specific order by ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Retrieve a list of all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Add more methods for updating and deleting orders as needed
}
