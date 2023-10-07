package com.nursery.payment;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRequest {
    private String paymentMethod;
    private Double amount;
    private Long orderId;
}