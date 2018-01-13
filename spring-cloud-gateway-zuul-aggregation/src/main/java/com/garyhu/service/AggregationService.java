package com.garyhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.garyhu.common.ResponseUtil;
import com.garyhu.common.Result;
import com.garyhu.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rx.Observable;

@Service
public class AggregationService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallback")
	public Observable<Result> getUserById(Long id){
		// 创建一个观察者
		return Observable.create(observer -> {
			// 请求用户微服务的{id}端点
			Result result = restTemplate.getForObject("http://springcloud1/{id}", Result.class,id);
			observer.onNext(result);
			observer.onCompleted();
		});
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	public Observable<Result> getMovieUserById(Long id){
		return Observable.create(observer -> {
			// 请求电影微服务的/user/{id}端点
			Result result = restTemplate.getForObject("http://springcloud2/user/{id}", Result.class,id);
			observer.onNext(result);
			observer.onCompleted();
		});
	}
	
	
	public Result fallback(Long id){
		User user = new User();
		user.setId(-1L);
		return ResponseUtil.success(user);
	}
}
