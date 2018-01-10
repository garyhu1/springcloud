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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class UserController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	//Hystrix的隔离策略默认为THREAD(线程隔离策略，开销比较大，请求次数过大的时候可以采用信号隔离策略),
	//一般采用THREAD就可以，当遇到找不到上下文的运行时异常时可采用SEMAPHORE
	@HystrixCommand(fallbackMethod="findByIdFallback",commandProperties={
			@HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE"),//修改隔离策略为信号隔离策略
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),
			@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value="1000")		
	},threadPoolProperties={
			@HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "10"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12")
	})
	@GetMapping("/user/{id}")
	public Result getUser(@PathVariable("id") Long id){
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
	
	@GetMapping("/test")
	public String findById(){
		//将会请求到: http://localhost:8060/,返回结果为： {"index":"欢迎来到首页"}
		return this.restTemplate.getForObject("http://springcloudzuulsidecar/", String.class);
	}
	
	//执行的回退方法（注意：执行回退方法时，并不意味着断路器已经打开）
	//请求失败、超时、被拒绝以及断路器被打开都会执行回退方法
	public Result findByIdFallback(Long id){
		User user = new User();
		user.setId(-1L);
		user.setName("默认用户");
		return ResponseUtil.success(user);
	}
	
	
	
}
