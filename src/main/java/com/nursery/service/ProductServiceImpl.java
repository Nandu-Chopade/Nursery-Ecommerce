package com.nursery.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.model.Product;
import com.nursery.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;
	
	@Autowired

	
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
    	product.setCreatedAt(new Date());
          return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            
            updatedProduct.setModifiedAt(new Date());
            return productRepository.save(updatedProduct);
        } else {
//            throw new NotFoundException("Product not found with id: " + id);
        }
		return updatedProduct;
    }

    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
//            throw new NotFoundException("Product not found with id: " + id);
        }
    }
}
