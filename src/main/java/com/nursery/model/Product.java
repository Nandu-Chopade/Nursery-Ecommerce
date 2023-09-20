package com.nursery.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private Categories category; // Associated category

    @JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews; // Product reviews

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems; // Cart items for this product
    
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
