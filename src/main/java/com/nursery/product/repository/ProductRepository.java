package com.nursery.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
