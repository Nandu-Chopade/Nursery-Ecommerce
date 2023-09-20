package com.nursery.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {

    private Long id;
    private String name;
    
    private List<ProductDTO> products;
}
