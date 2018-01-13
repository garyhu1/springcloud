package com.garyhu.controller;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.garyhu.ZuulAggregationApplication;
import com.garyhu.common.Result;
import com.garyhu.pojo.User;
import com.garyhu.service.AggregationService;
import com.google.common.collect.Maps;

import rx.Observable;
import rx.Observer;

@RestController
public class AggregationController {

	public static final Logger LOGGER = Logger.getLogger(ZuulAggregationApplication.class);
	
	@Autowired
	private AggregationService aggregationService;
	
	@GetMapping("/aggregate/{id}")
	public DeferredResult<HashMap<String,Result>> aggregate(@PathVariable Long id){
		Observable<HashMap<String,Result>> result = this.aggregateObservable(id);
		return this.toDeferredResult(result);
	}
	
	public Observable<HashMap<String,Result>> aggregateObservable(Long id){
		//合并两个或者多个Observable发射出的数据项，根据指定的函数变换他们
		return Observable.zip(
				this.aggregationService.getUserById(id), 
				this.aggregationService.getMovieUserById(id),
				(result,movieResult) -> {
					HashMap<String,Result> map = Maps.newHashMap();
					map.put("result", result);
					map.put("movieResult",movieResult);
					return map;
				});
	}
	
	public DeferredResult<HashMap<String,Result>> toDeferredResult(Observable<HashMap<String,Result>> details){
		DeferredResult<HashMap<String,Result>> result = new DeferredResult();
		//订阅
		details.subscribe(new Observer<HashMap<String,Result>>() {

			@Override
			public void onCompleted() {
				LOGGER.info("完成...");
			}

			@Override
			public void onError(Throwable throwable) {
				LOGGER.error("发生错误...",throwable);
			}

			@Override
			public void onNext(HashMap<String, Result> movieDetails) {
				result.setResult(movieDetails);
			}
		});
		
		return result;
	}
}
