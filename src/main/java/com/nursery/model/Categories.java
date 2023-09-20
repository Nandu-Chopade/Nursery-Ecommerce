package com.nursery.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categories {
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
