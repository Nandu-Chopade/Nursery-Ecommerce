package com.nursery.payment;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nursery.order.Order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod; // e.g., Credit Card, PayPal, etc.
    private BigDecimal amount;
    private Date paymentDate;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus; // Enum type for payment status

    public Payment(String paymentMethod, BigDecimal amount, Date paymentDate) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id") // Specify the foreign key column
    @JsonBackReference
    private Order order;
}
