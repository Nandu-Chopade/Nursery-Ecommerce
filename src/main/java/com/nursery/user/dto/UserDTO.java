package com.nursery.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nursery.Notification.Notification;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    
	@Size(min = 4, message = "Username must be min of 4 characters !!")
    private String username;
    private String firstName;
    private String lastName;
    private Long mobile;
    private String email;
    private String roles;
//  private Date createdA
//    private Date createdAt;
//    private Date modifiedAt;
//    private boolean isActive;
    
    List<Notification> notification;
    @JsonManagedReference
    private AddressDTO address; // Assuming AddressDTO is the DTO for the Address entity

  
}
