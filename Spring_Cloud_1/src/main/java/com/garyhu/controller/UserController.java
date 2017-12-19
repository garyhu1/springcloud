package com.garyhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.garyhu.entity.User;
import com.garyhu.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id){
		User user = userRepository.findOne(id);
		return user;
	}
}
