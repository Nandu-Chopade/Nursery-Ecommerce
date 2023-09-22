package com.nursery.cart;

import java.util.Date;

import com.nursery.product.dto.ProductDTO;
import com.nursery.shipping.ShippingSessionDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDTO {

    private Long id;
    private int quantity;
    private Date createdAt;
    private Date modifiedAt;
    private ProductDTO product;
    private ShippingSessionDTO sessionId;
}
