package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server
 * @author garyhu
 * 一个非高可用的服务注册中心
 */

@SpringBootApplication
@EnableEurekaClient
@EnableEurekaServer        //用来声明这是一个Eureka Server
public class ThirdApplication {

	public static void main(String[] args){
		SpringApplication.run(ThirdApplication.class, args);
	}
}
