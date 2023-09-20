package com.nursery.dto;

import java.util.Date;
import java.util.List;

import com.nursery.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private List<ProductDTO> products;
    private UserDTO user;
    private PaymentDTO payment;
}
