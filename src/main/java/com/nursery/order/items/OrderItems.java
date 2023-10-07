package com.nursery.order.items;

import java.util.Date;
import java.util.List;

import com.nursery.order.details.OrderDetails;
import com.nursery.product.model.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetails orderDetails;

    @ManyToMany
    @JoinTable(
        name = "order_product",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private Integer quantity;

    @PrePersist
    protected void onCreate() {
        this.orderDate = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
}
