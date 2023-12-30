package com.inm429.ecommerce.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inm429.ecommerce.Model.User;
import com.inm429.ecommerce.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUser(String emailId) {
		return userRepository.findByEmail(emailId);
	}
	
}
