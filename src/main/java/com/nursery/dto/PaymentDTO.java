package com.nursery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

import com.nursery.model.User;

@Getter
@Setter
public class PaymentDTO {

    private Long id;
    private String paymentMethod;
    private BigDecimal amount;
    private Date paymentDate;
    private OrderDTO order; // Assuming OrderDTO is the DTO for the Order entity
}
