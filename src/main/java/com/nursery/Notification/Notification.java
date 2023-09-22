package com.nursery.Notification;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.nursery.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User recipient;

    private String type;
    private String message;
    private LocalDateTime timestamp;
    private boolean read;
    // Add other fields as needed

    // getters and setters
}
