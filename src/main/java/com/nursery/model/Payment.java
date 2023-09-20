package com.nursery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod; // e.g., Credit Card, PayPal, etc.
    private BigDecimal amount;
    private Date paymentDate;

    public Payment(String paymentMethod, BigDecimal amount, Date paymentDate) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id") // Specify the foreign key column
    private Order order;
}
