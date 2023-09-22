package com.nursery.product.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesDTO {

    private Long id;
    private String name;
    
    private List<ProductDTO> products;
}
