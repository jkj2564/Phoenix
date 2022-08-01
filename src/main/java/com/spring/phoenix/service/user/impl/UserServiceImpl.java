package com.spring.phoenix.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.phoenix.entitiy.User;
import com.spring.phoenix.repository.UserRepository;
import com.spring.phoenix.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void join(User user) {
		userRepository.save(user);
	}
	
	@Override
	public User idCheck(String userId) {
		if(userRepository.findById(userId).isPresent()) {
			return userRepository.findById(userId).get();
		} else {
			return null;
		}
	}
}
