package com.db.h2database.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.h2database.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	private List getAllUsers() {
		return userService.getAllUsers();
//		return new ArrayList<>();
	}
	
}
