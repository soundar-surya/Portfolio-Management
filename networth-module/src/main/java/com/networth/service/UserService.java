package com.networth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.networth.model.User;
import com.networth.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List getAllUsers() {
		
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		
		return users;
	}
	
}
