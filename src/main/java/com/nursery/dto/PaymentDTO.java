package com.nursery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private Long id;
    private String paymentMethod;
    private BigDecimal amount;
    private Date paymentDate;
    private OrderDTO order; // Assuming OrderDTO is the DTO for the Order entity
}
