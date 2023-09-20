package com.nursery.dto;

import lombok.Data;
import java.util.Date;

@Data
public class CartItemDTO {

    private Long id;
    private int quantity;
    private Date createdAt;
    private Date modifiedAt;
    private ProductDTO product;
    private ShippingSessionDTO sessionId;
}
