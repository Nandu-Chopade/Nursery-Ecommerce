package com.nursery.product.service;

import java.util.List;
import java.util.Optional;

import com.nursery.product.dto.ProductDTO;
import com.nursery.product.model.Product;

public interface ProductService {

	List<ProductDTO> getAllProducts();

	 Optional<ProductDTO> getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product updatedProduct);

    void deleteProduct(Long id);
}
