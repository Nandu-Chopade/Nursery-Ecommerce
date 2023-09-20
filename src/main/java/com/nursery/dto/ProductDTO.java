package com.nursery.dto;

import java.util.Date;
import java.util.List;

import com.nursery.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
