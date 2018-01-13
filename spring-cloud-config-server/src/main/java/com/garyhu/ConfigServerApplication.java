package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config-server的配置
 * @author garyhu
 * 可以访问/{application}/{profiles}[/{label}];
 *       /{application}-{profiles}.yml;
 *       /{label}/{application}-{profiles}.yml;
 *       /{application}-{profiles}.properties;
 *       /{label}/{application}-{profiles}.properties;
 * label表示git仓库的分支，application表示微服务的名称，profiles表示别名
 * 
 * 例如可访问本项目的
 * http://localhost:8070/microservice-foo/dev 
 * http://localhost:8070/microservice-foo-dev.properties
 * http://localhost:8070/microservice-foo-dev.yml    
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class,args);
	}
}
