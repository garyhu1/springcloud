package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用Zuul聚合微服务
 * @author garyhu
 * 只需要发一个请求给zuul，由zuul请求用户微服务以及电影微服务，并组织好数据发送出去
 * 使用RxJava结合zuul来实现微服务请求的聚合
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulAggregationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulAggregationApplication.class,args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
