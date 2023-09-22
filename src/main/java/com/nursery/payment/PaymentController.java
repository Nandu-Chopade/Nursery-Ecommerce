package com.nursery.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.order.Order;
import com.nursery.order.OrderService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    
	@Autowired
    private PaymentService paymentService;
	
	@Autowired
	private OrderService orderService;

    @PostMapping("order/{orderId}")
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest request ,
       
            @PathVariable Long orderId) {
 
        Order order = orderService.getOrderByIds(orderId);

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Payment payment = paymentService.createPayment(request,orderId);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);

        if (payment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(payment);
    }
}
