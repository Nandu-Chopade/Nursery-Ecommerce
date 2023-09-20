package com.nursery.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

