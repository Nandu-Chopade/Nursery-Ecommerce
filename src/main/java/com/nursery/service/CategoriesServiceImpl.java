package com.nursery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.dao.CategoriesRepository;
import com.nursery.model.Categories;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
    private CategoriesRepository categoriesRepository;
   

    @Override
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Optional<Categories> getCategoryById(Long id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public Categories createCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    @Override
    public Categories updateCategory(Long id, Categories updatedCategory) {
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
