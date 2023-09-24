package com.nursery.cart;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();

    CartItem getCartItemById(Long id);

    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItem(Long id, CartItem cartItem);

    void deleteCartItem(Long id);
    
    CartItem addToCart(CartItem cartItem, Long userId, Long productId);
}
