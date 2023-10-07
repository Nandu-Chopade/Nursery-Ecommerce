package com.nursery.user.service;

import java.util.List;
import java.util.Optional;

import com.nursery.config.AuthRequest;
import com.nursery.user.dto.UserDTO;
import com.nursery.user.model.User;

public interface UserService {
   
	AuthRequest loginUser(AuthRequest auth);
	
	User registerNewUser(User user);
	
	public List<UserDTO> getAllUsers(); 

    public Optional<UserDTO> getUserById(Long id); 

    public void deleteUser(Long id); 
}
