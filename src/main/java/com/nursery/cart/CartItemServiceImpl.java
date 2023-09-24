 package com.nursery.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.product.model.Product;
import com.nursery.product.repository.ProductRepository;
import com.nursery.shipping.ShippingSession;
import com.nursery.shipping.ShippingSessionRepository;
import com.nursery.user.model.User;
import com.nursery.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
    private CartItemRepository cartItemRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private ShippingSessionRepository shippingSessionRepository;
	
    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem getCartItemById(Long id) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(id);
        return optionalCartItem.orElse(null);
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long id, CartItem cartItem) {
        if (cartItemRepository.existsById(id)) {
            cartItem.setId(id);
            return cartItemRepository.save(cartItem);
        } else {
            return null; // Handle the case where the cart item doesn't exist
        }
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
    
    @Override
    public CartItem addToCart(CartItem cartItem, Long userId, Long productId) {
    	 User user = userRepository.findById(userId).get();
    	 Product product = productRepository.findById(productId).get();
    	 cartItem.setProduct(product);
    	 ShippingSession session = new ShippingSession();
    	 Double price = product.getPrice();
    	 Integer quantity = cartItem.getQuantity();
    	 Double total = quantity * price;
    	 session.setUser(user);
    	 session.setTotal(total);
    	 shippingSessionRepository.save(session);
    	return cartItemRepository.save(cartItem);
    }
}
