package com.nursery.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private BigDecimal totalPrice;

    // Constructors, getters, and setters

    public CartItem() {
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // Constructors, getters, and setters

    // Calculate and update the total price for this cart item
//    public void updateTotalPrice() {
//        totalPrice = product.getPPrice().multiply(BigDecimal.valueOf(quantity));
//    }
}
