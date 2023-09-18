package com.nursery.model;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String district;
    private String state;
    private String pinCode;
    
    @OneToOne(mappedBy = "address")
//    @JsonBackReference
    private User user;
}
