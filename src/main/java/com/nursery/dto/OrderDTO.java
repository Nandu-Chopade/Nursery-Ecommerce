package com.nursery.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private List<ProductDTO> products;
    private UserDTO user;
    private PaymentDTO payment;
}
