package com.nursery.service;

import java.util.List;
import java.util.Optional;

import com.nursery.model.User;

public interface UserService {
   
	User saveUser(User user);
	
	public List<User> getAllUsers(); 

    public Optional<User> getUserById(Long id); 

    public void deleteUser(Long id); 
}
