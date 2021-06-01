package com.networth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.networth.model.ApiResponse;
import com.networth.model.User;
import com.networth.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ApiResponse<List<User>> listUser(){
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
	}

	
}


	