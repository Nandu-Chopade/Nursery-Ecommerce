package com.nursery.service;

import com.nursery.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();

    CartItem getCartItemById(Long id);

    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItem(Long id, CartItem cartItem);

    void deleteCartItem(Long id);
}
