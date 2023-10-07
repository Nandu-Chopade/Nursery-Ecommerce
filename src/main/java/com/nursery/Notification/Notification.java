package com.nursery.Notification;

import java.time.LocalDateTime;

import jakarta.persistence.*;

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

    private String type;
    private String message;
    private LocalDateTime timestamp;
    
    @Column(name = "`read`")
    private boolean read;
    

    @ManyToOne
    private User recipient;

    // Add other fields as needed

    // getters and setters
}
