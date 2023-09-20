package com.nursery.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.nursery.model.User;

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
