package com.nursery.order.items;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nursery.com/orders")
public class OrderController {

	@Autowired
    private OrderService orderService;

	@PostMapping("/place/order/user/{userId}/products/{productId}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
    public ResponseEntity<OrderItems> createOrder(@RequestBody OrderItems order, @PathVariable Long productId, @PathVariable Long userId) {

		OrderItems  orederItem =  orderService.placeYourOrder(order, productId, userId);

		return new ResponseEntity<>(orederItem , HttpStatus.OK);
	}

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
    public ResponseEntity<OrderItemDTO> getOrderById(@PathVariable Long id) {
        try {
            OrderItemDTO orderDTO = orderService.getOrderById(id);
            return new ResponseEntity<>(orderDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<OrderItemDTO>> getAllOrders() {
        List<OrderItemDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
