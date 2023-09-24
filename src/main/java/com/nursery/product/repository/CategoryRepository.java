package com.nursery.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.product.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
