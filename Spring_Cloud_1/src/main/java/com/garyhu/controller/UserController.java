package com.garyhu.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.garyhu.entity.User;
import com.garyhu.repository.UserRepository;
import com.garyhu.util.ResponseUtil;
import com.garyhu.util.Result;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/{id}")
	public Result findById(@PathVariable Long id){
		System.out.println("登录成功");
		Object principal = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if(principal instanceof UserDetails){
			UserDetails user = (UserDetails) principal;
			Collection<? extends GrantedAuthority> collection = user.getAuthorities();
			for(GrantedAuthority ga : collection){
				//打印当前登录用户的信息
				UserController.LOGGER.info("当前用户是{}, 角色是{}",user.getUsername(),ga.getAuthority());
			}
		}else {
			// do other things
		}
		User user = userRepository.findOne(id);
		return ResponseUtil.success(user);
	}
	
	@GetMapping("/")
	public Result index(){
		ServiceInstance instance = client.getLocalServiceInstance();
		return ResponseUtil.success(instance);
	}
}
