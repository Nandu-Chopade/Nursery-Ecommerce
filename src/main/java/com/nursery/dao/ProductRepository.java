package com.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
