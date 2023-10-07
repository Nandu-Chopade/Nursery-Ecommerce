package com.nursery.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nursery.com/payment")
public class PaymentController {
    
	@Autowired
    private PaymentService paymentService;
	
//	@Autowired
//	private OrderService orderService;

    @GetMapping("/get/{paymentId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);

        if (payment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(payment);
    }
}
