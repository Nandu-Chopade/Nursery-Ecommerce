package com.nursery.payment;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRequest {
    private String paymentMethod;
    private BigDecimal amount;
    private Date paymentDate;
    private Long orderId;
}
