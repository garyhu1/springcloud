package com.garyhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.garyhu.entity.User;
import com.garyhu.repository.UserRepository;
import com.garyhu.util.ResponseUtil;
import com.garyhu.util.Result;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/{id}")
	public Result findById(@PathVariable Long id){
		User user = userRepository.findOne(id);
		return ResponseUtil.success(user);
	}
	
	@GetMapping("/")
	public Result index(){
		ServiceInstance instance = client.getLocalServiceInstance();
		return ResponseUtil.success(instance);
	}
}
