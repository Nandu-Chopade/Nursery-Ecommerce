package com.nursery.user.service;

import java.util.List;
import java.util.Optional;

import com.nursery.user.dto.AddressDTO;
import com.nursery.user.model.Address;

 public interface AddressService {

 
	 List<AddressDTO> getAllAddresses();
	 AddressDTO getAddressById(Long id);
     Address saveAddress(Address address);
     void deleteAddress(Long id);
     Optional<Address> getAddressByIds(Long id);

 
}