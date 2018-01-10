package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 使用Turbine监控多个服务
 * @author garyhu
 * Hystrix只能一次监控一个，查看别的需要切换，比较麻烦
 * 在http://localhost:8033/hystrix的网页的url栏中填写http://localhost:8040/turbine.stream，Title随意写，然后点击Monitor Stream
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class TurbineApplication {

	public static void main(String[] args)throws Exception{
		SpringApplication.run(TurbineApplication.class,args);
	}
}