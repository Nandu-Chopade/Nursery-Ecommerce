package com.nursery.shipping;

import java.util.Date;
import java.util.List;

import com.nursery.cart.CartItemDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingSessionDTO {

    private Long id;
    private double total;
    private Date createdAt;
    private Date modifiedAt;
    private List<CartItemDTO> cartItems;
}
