package com.nursery.product.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nursery.cart.CartItem;
import com.nursery.order.items.OrderItems;
import com.nursery.reviews.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Product name

    private String size; // Product size

    private String color; // Product color

    private String type; // Product type

    private String description; // Product description

    private double price; // Product price

    private int stockQuantity; // Available quantity in stock

    private boolean available; // Is the product available?

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modifiedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category; // Associated category

    @JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews; // Product reviews

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems; // Cart items for this product
    
    @ManyToMany(mappedBy = "products")
    private List<OrderItems> orders;
    
    
}
