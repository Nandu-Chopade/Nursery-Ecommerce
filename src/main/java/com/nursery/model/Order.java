package com.nursery.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ORDER_TABLE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    // Other fields and getters/setters...

    // Add a @PrePersist method to set the orderDate before persisting
    @PrePersist
    protected void onCreate() {
        this.orderDate = new Date();
    }
    
    
    @ManyToOne
    @JsonBackReference
    private User user;


}
