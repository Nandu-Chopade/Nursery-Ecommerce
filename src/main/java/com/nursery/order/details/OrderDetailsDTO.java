package com.nursery.order.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.nursery.order.items.OrderItemDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    private Long id;
    private Long userId; // Represent the user's ID
    private List<OrderItemDTO> orderItems; // Assuming you have an OrderItemsDTO class
    private Double total;
    private Long paymentId; // Represent the payment's ID
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
