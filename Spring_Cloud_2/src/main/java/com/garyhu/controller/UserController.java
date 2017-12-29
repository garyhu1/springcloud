package com.garyhu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.garyhu.feign.UserFeignClient;
import com.garyhu.pojo.User;
import com.garyhu.util.ResponseUtil;
import com.garyhu.util.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
//	@HystrixCommand(fallbackMethod="findByIdFallback")
	@GetMapping("/user/{id}")
	public Result getUser(@PathVariable Long id){
		Result result  = this.userFeignClient.getResultById(id);
		return result;
	}
	
	@GetMapping("/")
	public Result index(){
		List<ServiceInstance> list = client.getInstances("Spring_Cloud_1");
		return ResponseUtil.success(list.get(0));
	}
	
	//查询Spring_Cloud_1的信息
	@GetMapping("/cloud_1/info")
	public Result getCloudInfo(){
		List<ServiceInstance> o = client.getInstances("Spring_Cloud_1");
		return ResponseUtil.success(o);
	}
	
	@GetMapping("/log-instance")
	public void logInstance(){
		ServiceInstance instance = this.loadBalancerClient.choose("Spring_Cloud_1");
		UserController.LOGGER.info("{}:{}:{}",instance.getServiceId(),instance.getHost(),instance.getPort());
	}
	
	public Result findByIdFallback(Long id){
		User user = new User();
		user.setId(-1L);
		user.setName("默认用户");
		return ResponseUtil.success(user);
	}
	
}
