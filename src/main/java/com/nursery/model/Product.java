package com.nursery.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
  
    private String pName;
    
    private String pSize;
    
    private String pColor;
    
    private String pType;
    
    private String pDescription;
    
    private double pPrice;
    
    private int pStockQuantity;
    
    private boolean pAvailable;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date pCreationTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date pUpdatedTime;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Categories categories;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;
    
    // Constructors, getters, setters, and other methods
}
