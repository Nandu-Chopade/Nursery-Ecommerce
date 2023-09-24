package com.nursery.cart;

import java.util.Date;

import jakarta.persistence.*;

import com.nursery.product.model.Product;
import com.nursery.shipping.ShippingSession;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    
    @ManyToOne
    @JoinColumn(name = "product_id") // This is the foreign key column
    private Product product; // Represents the associated Product

    @ManyToOne
    @JoinColumn(name = "session_id")
    private ShippingSession sessionId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modifiedAt;
}
