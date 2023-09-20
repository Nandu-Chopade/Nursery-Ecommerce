package com.nursery.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.dto.AddressDTO;
import com.nursery.dto.RoleDTO;
import com.nursery.dto.UserDTO;
import com.nursery.model.User;
import com.nursery.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
	    return userRepository.findAll().stream().map(users -> {
	        UserDTO userDTO = new UserDTO();
	        userDTO.setId(users.getId());
	        userDTO.setFirstName(users.getFirstName());
	        userDTO.setLastName(users.getLastName());
	        userDTO.setUsername(users.getUsername());
	        userDTO.setMobile(users.getMobile());
	        userDTO.setEmail(users.getEmail());
	        System.out.println(users.getAddress());
	        // Check if the user has an address
	        if (users.getAddress() != null) {
	            // Convert Address to AddressDTO
	            AddressDTO addressDTO = new AddressDTO();
	            addressDTO.setId(users.getAddress().getId());
	            addressDTO.setStreet(users.getAddress().getStreet());
	            addressDTO.setCity(users.getAddress().getCity());
	            addressDTO.setDistrict(users.getAddress().getDistrict());
	            addressDTO.setState(users.getAddress().getState());
	            addressDTO.setPinCode(users.getAddress().getPinCode());

	            userDTO.setAddress(addressDTO);
	        }
	        // Check if the user has roles
	        if (users.getRoles() != null) {
	            // Convert roles to RoleDTOs
	            Set<RoleDTO> roleDTOs = users.getRoles().stream().map(role -> {
	                RoleDTO roleDTO = new RoleDTO();
	                roleDTO.setId(role.getId());
	                roleDTO.setName(role.getName());
	                return roleDTO;
	            }).collect(Collectors.toSet());

	            userDTO.setRoles(roleDTOs);
	        }
	        return userDTO;
	    }).collect(Collectors.toList());
	}


	@Override
	public Optional<UserDTO> getUserById(Long id) {
	    return userRepository.findById(id).map(user -> {
	        UserDTO userDTO = new UserDTO();
	        userDTO.setId(user.getId());
	        userDTO.setFirstName(user.getFirstName());
	        userDTO.setLastName(user.getLastName());
	        userDTO.setUsername(user.getUsername());
	        userDTO.setMobile(user.getMobile());
	        userDTO.setEmail(user.getEmail());
	        
	     // Check if the user has an address
	        if (user.getAddress() != null) {
	            // Convert Address to AddressDTO
	            AddressDTO addressDTO = new AddressDTO();
	            addressDTO.setId(user.getAddress().getId());
	            addressDTO.setStreet(user.getAddress().getStreet());
	            addressDTO.setCity(user.getAddress().getCity());
	            addressDTO.setDistrict(user.getAddress().getDistrict());
	            addressDTO.setState(user.getAddress().getState());
	            addressDTO.setPinCode(user.getAddress().getPinCode());

	            userDTO.setAddress(addressDTO);
	        }
	        
	        // Check if the user has roles
	        if (user.getRoles() != null) {
	            // Convert roles to RoleDTOs
	            Set<RoleDTO> roleDTOs = user.getRoles().stream().map(role -> {
	                RoleDTO roleDTO = new RoleDTO();
	                roleDTO.setId(role.getId());
	                roleDTO.setName(role.getName());
	                return roleDTO;
	            }).collect(Collectors.toSet());

	            userDTO.setRoles(roleDTOs);
	        }
	        
	        return userDTO;
	    });
	}



    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
