package com.nursery.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.product.model.Category;
import com.nursery.product.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
    private CategoryRepository categoriesRepository;
   

    @Override
    public List<Category> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categoriesRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        if (categoriesRepository.existsById(id)) {
            updatedCategory.setId(id);
            return categoriesRepository.save(updatedCategory);
        } else {
//            throw new NotFoundException("Category not found with id: " + id);
        }
		return updatedCategory;
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoriesRepository.existsById(id)) {
            categoriesRepository.deleteById(id);
        } else {
//            throw new NotFoundException("Category not found with id: " + id);
        }
    }
}
