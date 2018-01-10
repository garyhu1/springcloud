package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 使用Hystrix Dashboard 可视化监控数据
 * @author garyhu
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApplication {
	
	public static void main (String[] args)throws Exception{
		SpringApplication.run(DashboardApplication.class, args);
	}

}
