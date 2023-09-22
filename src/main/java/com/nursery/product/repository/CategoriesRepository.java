package com.nursery.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.product.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>  {

}
