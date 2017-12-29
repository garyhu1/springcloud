package com.myfeign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.auth.BasicAuthRequestInterceptor;
/**
 * 还可以自定feign的编码器、解码器、日志打印、拦截器
 * @author garyhu
 * 自定义一个feign的拦截器
 */
@Configuration
public class FooFeignConfiguration {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
		return new BasicAuthRequestInterceptor("user","password");
	}
}
