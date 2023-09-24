package com.nursery.order.items;

import java.util.Date;
import java.util.List;

import com.nursery.payment.PaymentDTO;
import com.nursery.product.dto.ProductDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {

    private Long id;
    private Date orderDate;
    private List<ProductDTO> products;
    private PaymentDTO payment;
}
