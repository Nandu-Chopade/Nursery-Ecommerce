package com.nursery.user.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nursery.Notification.Notification;
import com.nursery.order.details.OrderDetails;
import com.nursery.order.items.OrderItems;
import com.nursery.payment.Payment;
import com.nursery.reviews.Review;
import com.nursery.shipping.ShippingSession;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long   mobile;
    private String email;

    // Add createdAt and modifiedAt fields with default values
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, nullable = false)
    private Date createdAt = new Date(); // Set default value to current timestamp

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt = new Date(); // Set default value to current timestamp

    private boolean isActive = true; // Set default value to true

    // Rest of your entity mappings...
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    private String roles;
    
    @OneToMany(mappedBy = "user")
    private List<OrderDetails> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Review> reviews;
    
    @OneToMany(mappedBy = "recipient")
    List<Notification> notification;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ShippingSession> shippingSessions;

}
