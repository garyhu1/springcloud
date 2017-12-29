package com.garyhu.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义的负载均衡（也可以通过配置文件来设置）
 * @author garyhu
 *
 */
//@Configuration
public class RibbonConfiguration {

//	@Bean
	public IRule ribbonRule(){
		//负责均衡改为随机
		return new RandomRule();
	}
}
