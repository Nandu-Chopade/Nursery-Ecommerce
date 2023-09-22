package com.nursery.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.user.dto.AddressDTO;
import com.nursery.user.model.Address;
import com.nursery.user.repository.AddressRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
    private AddressRepository addressRepository;

   

	@Override
    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        
        // Map the list of Address entities to a list of AddressDTOs using lambda expressions
        List<AddressDTO> addressDTOs = addresses.stream()
            .map(address -> {
                AddressDTO addressDTO = new AddressDTO();
                addressDTO.setId(address.getId());
                addressDTO.setStreet(address.getStreet());
                addressDTO.setCity(address.getCity());
                addressDTO.setDistrict(address.getDistrict());
                addressDTO.setState(address.getState());
                addressDTO.setPinCode(address.getPinCode());
                return addressDTO;
            })
            .collect(Collectors.toList());

        return addressDTOs;
    }
	
    @Override
    public AddressDTO getAddressById(Long id) {
        // Find the address by ID
        return addressRepository.findById(id)
                .map(address -> {
                    AddressDTO addressDTO = new AddressDTO();
                    addressDTO.setId(address.getId());
                    addressDTO.setStreet(address.getStreet());
                    addressDTO.setCity(address.getCity());
                    addressDTO.setDistrict(address.getDistrict());
                    addressDTO.setState(address.getState());
                    addressDTO.setPinCode(address.getPinCode());
                    return addressDTO;
                })
                .orElse(null); // Return null if the address is not found
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

	@Override
	public Optional<Address> getAddressByIds(Long id) {
		return addressRepository.findById(id);
	}
}


