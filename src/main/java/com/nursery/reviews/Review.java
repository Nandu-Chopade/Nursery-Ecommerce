package com.nursery.reviews;

import java.util.Date;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nursery.product.model.Product;
import com.nursery.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// This is child class of user
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int rating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
    @JsonBackReference
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
    
    @JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id")   
    private Product product;


}