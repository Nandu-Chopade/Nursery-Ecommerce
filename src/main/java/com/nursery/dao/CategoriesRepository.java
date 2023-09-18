package com.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>  {

}
