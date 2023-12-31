package com.nursery.product.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.product.dto.CategoriesDTO;
import com.nursery.product.dto.ProductDTO;
import com.nursery.product.model.Category;
import com.nursery.product.model.Product;
import com.nursery.product.repository.CategoryRepository;
import com.nursery.product.repository.ProductRepository;
import com.nursery.reviews.ReviewDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoriesRepository;

	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();

		List<ProductDTO> productDTOs = products.stream().map(product -> {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setSize(product.getSize());
			productDTO.setColor(product.getColor());
			productDTO.setType(product.getType());
			productDTO.setDescription(product.getDescription());
			productDTO.setPrice(product.getPrice());
			productDTO.setStockQuantity(product.getStockQuantity());
			productDTO.setAvailable(product.isAvailable());
			productDTO.setCreatedAt(product.getCreatedAt());
			productDTO.setModifiedAt(product.getModifiedAt());

			// Map Categories
			CategoriesDTO categoriesDTO = new CategoriesDTO();
			categoriesDTO.setId(product.getCategory().getId());
			categoriesDTO.setName(product.getCategory().getName());
			productDTO.setCategory(categoriesDTO);

			// Map Reviews
			List<ReviewDTO> reviewDTOs = product.getReviews().stream().map(review -> {
				ReviewDTO reviewDTO = new ReviewDTO();
				reviewDTO.setId(review.getId());
				reviewDTO.setComment(review.getComment());
				reviewDTO.setRating(review.getRating());
				reviewDTO.setCreatedAt(review.getCreatedAt());
				return reviewDTO;
			}).collect(Collectors.toList());

			productDTO.setReviews(reviewDTOs);

			// You can add mappings for other fields such as cartItems and orders here

			return productDTO;
		}).collect(Collectors.toList());

		return productDTOs;
	}

	@Override
	public Optional<ProductDTO> getProductById(Long id) {
		return productRepository.findById(id).map(product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setSize(product.getSize());
			productDTO.setColor(product.getColor());
			productDTO.setType(product.getType());
			productDTO.setDescription(product.getDescription());
			productDTO.setPrice(product.getPrice());
			productDTO.setStockQuantity(product.getStockQuantity());
			productDTO.setAvailable(product.isAvailable());
			productDTO.setCreatedAt(product.getCreatedAt());
			productDTO.setModifiedAt(product.getModifiedAt());

			// Map Reviews
			List<ReviewDTO> reviewDTOs = product.getReviews().stream().map(review -> {
				ReviewDTO reviewDTO = new ReviewDTO();
				reviewDTO.setId(review.getId());
				reviewDTO.setComment(review.getComment());
				reviewDTO.setRating(review.getRating());
				reviewDTO.setCreatedAt(review.getCreatedAt());
				return reviewDTO;
			}).collect(Collectors.toList());

			productDTO.setReviews(reviewDTOs);

			// Map Categories
			CategoriesDTO categoriesDTO = new CategoriesDTO();
			categoriesDTO.setId(product.getCategory().getId());
			categoriesDTO.setName(product.getCategory().getName());
			productDTO.setCategory(categoriesDTO);

			// You can add mappings for other fields such as cartItems and orders here

			return productDTO;
		});
	}

	@Override
	public Product createProduct(Product product, Long categoryId) {
		Category category = categoriesRepository.findById(categoryId).get();
		product.setCategory(category);
		product.setCreatedAt(new Date());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product updatedProduct) {
		if (productRepository.existsById(id)) {
			updatedProduct.setId(id);
			updatedProduct.setModifiedAt(new Date());
			return productRepository.save(updatedProduct);
		} else {
			// Handle the case when the product is not found
			// For example, throw an exception or return a specific response
			// throw new NotFoundException("Product not found with id: " + id);
			// You can customize this part based on your application's error handling
			// strategy
		}
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
		} else {
			// Handle the case when the product is not found
			// For example, throw an exception or return a specific response
			// throw new NotFoundException("Product not found with id: " + id);
			// You can customize this part based on your application's error handling
			// strategy
		}
	}

}
