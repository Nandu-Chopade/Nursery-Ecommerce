package com.nursery.product.service;

import java.util.List;
import java.util.Optional;

import com.nursery.product.model.Category;

public interface CategoriesService {

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category updatedCategory);

    void deleteCategory(Long id);
}
