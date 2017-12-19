package com.garyhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.garyhu.pojo.User;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id){
		return this.restTemplate.getForObject("http://127.0.0.1:8000/"+id, User.class);
	}
}
