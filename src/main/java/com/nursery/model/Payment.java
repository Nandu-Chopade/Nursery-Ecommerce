package com.nursery.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod; // e.g., Credit Card, PayPal, etc.
    private BigDecimal amount;
    private Date paymentDate;

    // Constructors, getters, and setters

    public Payment() {
    }

    public Payment(String paymentMethod, BigDecimal amount, Date paymentDate) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id") // Specify the foreign key column
    private Order order;
    // getters and setters

    // Equals and hashCode methods
    // You can customize these methods as needed
}
