package com.nursery.order.details;

import java.time.LocalDateTime;
import java.util.List;

import com.nursery.order.items.OrderItems;
import com.nursery.payment.Payment;
import com.nursery.user.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "orderDetails", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;
    
    
    private Double total;
    
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
   
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
