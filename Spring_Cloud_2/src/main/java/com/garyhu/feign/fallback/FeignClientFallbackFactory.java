package com.garyhu.feign.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garyhu.feign.UserFeignClient;
import com.garyhu.pojo.User;
import com.garyhu.util.ResponseUtil;
import com.garyhu.util.Result;

import feign.hystrix.FallbackFactory;

/**
 * @info: UserFeignClientd的fallbackFactory类，
 *        该类需要实现FallbackFactory接口，并覆写create方法
 * @author: garyhu
 *
 * 如果UserFeignClient设置了fallback属性时，该类不会执行
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	
	//可以根据异常的类型返回不同的fallback
	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient(){

			@Override
			public Result getResultById(Long id) {
				//日志最好放到fallback中，而不是在create方法中，否则在应用启动时就会打印日志
				FeignClientFallbackFactory.LOGGER.info("fallback reason was : ",cause);
				User user = new User();
				//注：cause有可能是Null,在9.40版本已经解决了
				if(cause instanceof IllegalArgumentException){
					user.setId(-200L);
				}else {
					user.setId(-2L);
				}
				user.setName("默认用户B");
				return ResponseUtil.success(user);
			}
			
		};
	}

}
