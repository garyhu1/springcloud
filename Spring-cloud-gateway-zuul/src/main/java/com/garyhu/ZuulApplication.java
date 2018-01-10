package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

import com.garyhu.zuulfilter.PreRequestLogFilter;

/**
 * Zuul微服务网关
 * @author garyhu
 * 可以在配置文件中指定或者忽略微服务的访问路径
 * 也可以使用正则表达式指定zuul的路由匹配规则
 */
@SpringBootApplication
//该代理还整合了Hystrix,所有经过zuul的请求都会在Hystrix命令中执行
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {

	public static void main(String[] args)throws Exception{
		SpringApplication.run(ZuulApplication.class, args);
	}
	
    /**
     * 正则表达式来指定zuul的路由匹配规则
     */
//	@Bean
	public PatternServiceRouteMapper serviceRouteMapper(){
		//servicePattern指定微服务的正则
		//routePattern指定路由正则
		return new PatternServiceRouteMapper("servicePattern", "routePattern");
	}
	
	/**
	 * 给应用添加自定义的过滤器
	 */
	@Bean
	public PreRequestLogFilter preRequestLogFilter(){
		return new PreRequestLogFilter();
	}
}
