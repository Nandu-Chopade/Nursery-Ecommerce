package com.nursery.user.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String district;
    private String state;
    private String pinCode;

    
    @JsonBackReference
    private UserDTO user;
}

