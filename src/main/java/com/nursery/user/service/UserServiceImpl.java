package com.nursery.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nursery.config.AuthRequest;
import com.nursery.user.dto.AddressDTO;
import com.nursery.user.dto.UserDTO;
import com.nursery.user.model.User;
import com.nursery.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User registerNewUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
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
			userDTO.setRoles(users.getRoles());

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
			userDTO.setRoles(user.getRoles());

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
			return userDTO;
		});
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public AuthRequest loginUser(AuthRequest auth) {
		auth.setUsername(auth.getUsername());
		auth.setPassword(auth.getPassword());
		userRepository.findByUsernameAndPassword(auth.getUsername(), auth.getPassword());
		return null;
	}

}
