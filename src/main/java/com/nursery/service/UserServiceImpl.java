package com.nursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.dao.UserRepository;
import com.nursery.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	@Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
