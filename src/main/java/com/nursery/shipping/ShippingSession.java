package com.nursery.shipping;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

import com.nursery.cart.CartItem;
import com.nursery.user.model.User;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ShippingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double total;
    
    @OneToMany(mappedBy = "sessionId", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modifiedAt;
}
