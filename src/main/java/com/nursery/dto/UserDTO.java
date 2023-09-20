package com.nursery.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Long mobile;
    private String email;
//    private Date createdAt;
//    private Date modifiedAt;
//    private boolean isActive;

    private Set<RoleDTO> roles;
    @JsonManagedReference
    private AddressDTO address; // Assuming AddressDTO is the DTO for the Address entity

  
}
