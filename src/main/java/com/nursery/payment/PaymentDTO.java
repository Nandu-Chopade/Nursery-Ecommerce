package com.nursery.payment;

import java.math.BigDecimal;
import java.util.Date;

import com.nursery.order.items.OrderItemDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

    private Long id;
    private String paymentMethod;
    private BigDecimal amount;
    private Date paymentDate;
    private OrderItemDTO order; // Assuming OrderDTO is the DTO for the Order entity
}
