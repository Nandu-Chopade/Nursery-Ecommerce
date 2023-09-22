package com.nursery.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nursery.user.dto.AddressDTO;
import com.nursery.user.model.Address;
import com.nursery.user.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
	
	@Autowired
    private AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<AddressDTO>> getAllAddresses() {
	    List<AddressDTO> addressDTOs = addressService.getAllAddresses();

	    if (addressDTOs != null && !addressDTOs.isEmpty()) {
	        return new ResponseEntity<>(addressDTOs, HttpStatus.OK);
	    } else {
	        // If the list is null or empty, return a NOT_FOUND response
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.saveAddress(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        AddressDTO addressDTO = addressService.getAddressById(id);

        if (addressDTO != null) {
            return new ResponseEntity<>(addressDTO, HttpStatus.OK);
        } else {
            // If addressDTO is null, return a NOT_FOUND response
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (!addressService.getAddressByIds(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
