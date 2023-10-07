package com.nursery.cart;

import java.util.List;

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

@RestController
@RequestMapping("/nursery.com/cart")
public class CartItemController {
	@Autowired
	private CartItemService cartItemService;

	@GetMapping("/get/all")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public ResponseEntity<List<CartItem>> getAllCartItems() {
		List<CartItem> cartItems = cartItemService.getAllCartItems();
		return ResponseEntity.ok(cartItems);
	}

	@GetMapping("/get/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
		CartItem cartItem = cartItemService.getCartItemById(id);
		if (cartItem != null) {
			return ResponseEntity.ok(cartItem);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/addToCart/user/{userId}/product/{productId}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem, @PathVariable Long userId,
			@PathVariable Long productId) {
		CartItem addedCartItem = cartItemService.addToCart(cartItem, userId, productId);
		if (addedCartItem != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(addedCartItem);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItem) {
		
		CartItem updatedCartItem = cartItemService.updateCartItem(id, cartItem);
		if (updatedCartItem != null) {
			return ResponseEntity.ok(updatedCartItem);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
		
		cartItemService.deleteCartItem(id);
		return ResponseEntity.noContent().build();
	}
}
