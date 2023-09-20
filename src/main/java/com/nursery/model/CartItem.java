package com.nursery.model;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Data
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modifiedAt;

    @ManyToOne
    @JoinColumn(name = "product_id") // This is the foreign key column
    private Product product; // Represents the associated Product

    @ManyToOne
    @JoinColumn(name = "session_id")
    private ShippingSession sessionId;
}
