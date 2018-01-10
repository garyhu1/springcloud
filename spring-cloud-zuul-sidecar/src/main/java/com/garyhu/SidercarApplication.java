package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 项目中的@EnableSidecar是一个组合注解，它整合了@EnableCircuitBreaker、@EnableDiscoveryClient、@EnableZuulProxy
 * @author garyhu
 *
 */
@SpringBootApplication
@EnableSidecar
public class SidercarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SidercarApplication.class,args);
	}
}
