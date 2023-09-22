package com.nursery.order;

import java.util.Date;
import java.util.List;

import com.nursery.payment.PaymentDTO;
import com.nursery.product.dto.ProductDTO;
import com.nursery.user.dto.UserDTO;

import lombok.Getter;
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
