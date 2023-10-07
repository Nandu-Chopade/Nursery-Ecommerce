package com.nursery.product.model;

import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String name;
    @JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    
    // Constructors, getters, setters, and other methods
}
