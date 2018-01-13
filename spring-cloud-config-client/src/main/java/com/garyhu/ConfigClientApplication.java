package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Config client
 * @author garyhu
 *  SpringCloud 有一个“引导上下文”的概念，这是主应用程序的父上下文。
 *         引导上下文负责从配置服务器加载配置属性，以及解密外部配置文件中
 *         的属性。和主应用程序加载application.*(yml或properties)
 *         中的属性不同，引导上下文加载bootstrap.*中的属性。配置在
 *         bootstrap.*中的属性有更高的优先级，因此默认情况下他们不能被本地
 *         配置覆盖。
 *  如需禁用引导过程，可设置spring.cloud.bootstrap.enabled=false       
 *  
 *  启动 config server
 *  启动本项目
 *  然后可访问 http://localhost:8071/profile
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class,args);
	}
}
