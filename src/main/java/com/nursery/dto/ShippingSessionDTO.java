package com.nursery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingSessionDTO {

    private Long id;
    private double total;
    private Date createdAt;
    private Date modifiedAt;
    private List<CartItemDTO> cartItems;
}
