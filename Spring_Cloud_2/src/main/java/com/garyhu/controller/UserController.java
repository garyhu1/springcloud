package com.garyhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.garyhu.pojo.User;
import com.garyhu.util.ResponseUtil;
import com.garyhu.util.Result;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/user/{id}")
	public Result getUser(@PathVariable Long id){
//		List<ServiceInstance> list = client.getInstances("Spring_Cloud_1");
//		ServiceInstance instance = list.get(0);
		User user = this.restTemplate.getForObject("http://127.0.0.1:8000/"+id, User.class);
		return ResponseUtil.success(user);
	}
	
	@GetMapping("/")
	public Result index(){
		List<ServiceInstance> list = client.getInstances("Spring_Cloud_1");
		return ResponseUtil.success(list.get(0));
	}
}
