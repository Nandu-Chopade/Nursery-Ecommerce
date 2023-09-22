package com.nursery.product.dto;

import java.util.Date;
import java.util.List;

import com.nursery.reviews.ReviewDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
