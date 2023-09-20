package com.nursery.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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