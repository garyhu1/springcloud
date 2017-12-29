package com.garyhu.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.garyhu.pojo.User;
import com.garyhu.util.Result;
import com.myfeign.FooFeignConfiguration;
import com.myfeign.MyFeignConfiguration;

import feign.Param;
import feign.RequestLine;

/**
 * 声明式调用
 * configuration默认使用的是FeignClientConfiguration,可以自定义，自定义的优先级高于默认的
 * @author garyhu
 * 这里采用自定义的Feign配置，就可以使用feign自带的注解了
 */
@FeignClient(value="springcloud1",configuration={MyFeignConfiguration.class})
public interface UserFeignClient {
    
	/**
	 * 使用的不是feign自带的注解，是Spring MVC的注解
	 */
//	@RequestMapping(value="/{id}",method=RequestMethod.GET)
//	public Result findById(@PathVariable("id") Long id);
	
	/**
	 * 由于采用了自定义的feign的配置，所以下面使用feign自带的注解
	 */
	@RequestLine("GET /{id}")
	public Result getResultById(@Param("id") Long id);
	
	/**
	 * 使用@RequestParam来指定多参数的URL请求的参数是什么
	 */
//	@RequestMapping(value="/get",method=RequestMethod.GET)
//	public Result get1(@RequestParam("id") Long id,@RequestParam("username") String username);
	
	/**
	 * 使用Map来指定多参数的URL请求的参数是什么
	 */
//	@RequestMapping(value="/get",method=RequestMethod.GET)
//	public Result get2(@RequestParam Map<String,Object> map);
	
	/**
	 * post请求
	 */
//	@RequestMapping(value="/post",method=RequestMethod.POST)
//	public Result post(@RequestBody User user);
}
