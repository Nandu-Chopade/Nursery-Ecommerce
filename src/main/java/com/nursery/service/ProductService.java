package com.nursery.service;

import java.util.List;
import java.util.Optional;

import com.nursery.dto.ProductDTO;
import com.nursery.model.Product;

public interface ProductService {

	List<ProductDTO> getAllProducts();

	 Optional<ProductDTO> getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product updatedProduct);

    void deleteProduct(Long id);
}
