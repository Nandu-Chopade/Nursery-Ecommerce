package com.nursery.service;

import java.util.List;
import java.util.Optional;

import com.nursery.model.Categories;

public interface CategoriesService {

    List<Categories> getAllCategories();

    Optional<Categories> getCategoryById(Long id);

    Categories createCategory(Categories category);

    Categories updateCategory(Long id, Categories updatedCategory);

    void deleteCategory(Long id);
}
