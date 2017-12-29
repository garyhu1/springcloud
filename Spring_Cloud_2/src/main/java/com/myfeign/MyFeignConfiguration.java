package com.myfeign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * 该类为Feign的配置类
 * @author garyhu
 * 该文件和Ribbon的自定义配置文件一样，不能再主应用程序的上下文的@ComponentScan中，否则该类中的配置信息会被所以@FeignClient共享
 */

@Configuration
public class MyFeignConfiguration {

	/**
	 * 将契约改为Feign原生的默认的契约。这样就可以使用feign自带的注解了
	 * @return Feign原生的默认的契约
	 */
	@Bean
	public Contract feignContract(){
		return new feign.Contract.Default();
	}
}
