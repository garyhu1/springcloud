package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * 只要Hystrix在项目的classpath中，Feign就会使用断路器包裹Feign客户端的所有方法。
 * @author garyhu
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//为项目启动断路器支持
@EnableCircuitBreaker   //或者是@EnableHystrix 
public class SecondApplication {

	public static void main(String[] args)throws Exception{
		SpringApplication.run(SecondApplication.class, args);
	}
	
	@Bean
	@LoadBalanced //Ribbon的负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
