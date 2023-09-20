package com.nursery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Long mobile;
    private String email;
    private Date createdAt;
    private Date modifiedAt;
    private boolean isActive;
    
    // You can add other fields from the User entity if needed

    private AddressDTO address; // Assuming AddressDTO is the DTO for the Address entity

    private Set<RoleDTO> roles; // Assuming RoleDTO is the DTO for the Role entity
}
