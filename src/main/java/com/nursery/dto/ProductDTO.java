package com.nursery.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String size;
    private String color;
    private String type;
    private String description;
    private double price;
    private int stockQuantity;
    private boolean available;
    private Date createdAt;
    private Date modifiedAt;
    private CategoriesDTO category;
    private List<ReviewDTO> reviews;
    private List<CartItemDTO> cartItems;
    private List<OrderDTO> orders;
}
