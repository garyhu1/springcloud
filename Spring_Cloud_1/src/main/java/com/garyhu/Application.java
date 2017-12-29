package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 * @author garyhu
 *
 */

@SpringBootApplication    //应用程序的主入口
@EnableDiscoveryClient    // 声明这是一个Eureka Client
public class Application {

	public static void main(String[] args)throws Exception{
		SpringApplication.run(Application.class, args);
	}
}
