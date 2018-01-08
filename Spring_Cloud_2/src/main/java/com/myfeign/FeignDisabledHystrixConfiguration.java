package com.myfeign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;

/**
 * 如果想禁用hystrix，只需要设置下配置，（如configuration=FeignDisabledHystrixConfiguration.class）
 * 如果你想全局禁用，可以在配置文件中设置如（feign.hystrix.enabled=false）
 * @author garyhu
 *
 */
@Configuration
public class FeignDisabledHystrixConfiguration {

	@Bean
	@Scope("propotype")
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}
}
