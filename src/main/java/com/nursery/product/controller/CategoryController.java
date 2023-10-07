package com.nursery.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.product.model.Category;
import com.nursery.product.service.CategoriesService;

@RestController
@RequestMapping("/nursery.com/category")
public class CategoryController {

	@Autowired
	private CategoriesService categoriesService;

	@GetMapping("/get/all")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public ResponseEntity<List<Category>> getAllCategories() {
		// Add authorization check here, e.g., only allow authenticated users
		return new ResponseEntity<>(categoriesService.getAllCategories(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		Optional<Category> category = categoriesService.getCategoryById(id);
		return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/create")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category createdCategory = categoriesService.createCategory(category);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
		Category updatedCategory = categoriesService.updateCategory(id, category);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoriesService.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
