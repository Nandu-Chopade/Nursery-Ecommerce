package com.nursery.payment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponse {
    private String transactionId;
    private boolean success;
    private String message;
   
}