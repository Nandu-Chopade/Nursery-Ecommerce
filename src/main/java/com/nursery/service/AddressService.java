package com.nursery.service;

import java.util.List;
import java.util.Optional;

import com.nursery.dto.AddressDTO;
import com.nursery.model.Address;

 public interface AddressService {

 
	 List<AddressDTO> getAllAddresses();
	 AddressDTO getAddressById(Long id);
     Address saveAddress(Address address);
     void deleteAddress(Long id);
     Optional<Address> getAddressByIds(Long id);

 
}