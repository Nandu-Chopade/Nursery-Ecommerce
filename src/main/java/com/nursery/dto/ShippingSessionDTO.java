package com.nursery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import com.nursery.model.User;

@Getter
@Setter
public class ShippingSessionDTO {

    private Long id;
    private double total;
    private Date createdAt;
    private Date modifiedAt;
    private List<CartItemDTO> cartItems;
}
