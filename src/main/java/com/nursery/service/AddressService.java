package com.nursery.service;

import java.util.List;
import java.util.Optional;

import com.nursery.model.Address;

 public interface AddressService {

     List<Address> getAllAddresses();

     Optional<Address> getAddressById(Long id);

     Address saveAddress(Address address);
     void deleteAddress(Long id);
}