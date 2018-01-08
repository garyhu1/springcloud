package com.garyhu.feign.fallback;

import org.springframework.stereotype.Component;

import com.garyhu.feign.UserFeignClient;
import com.garyhu.pojo.User;
import com.garyhu.util.ResponseUtil;
import com.garyhu.util.Result;

/**
 * @info: UserFeignClient的回退方法
 * @author: garyhu
 * @description: 回退类 FeignClientFallback需要实现Feign Client接口 
 */
@Component
public class FeignClientFallback implements UserFeignClient {

	@Override
	public Result getResultById(Long id) {
		User user = new User();
		user.setId(-1L);
		user.setName("默认用户A");
		return ResponseUtil.success(user);
	}

}
