package com.garyhu.util;

import lombok.Data;

@Data
public class Result<T> {

	private int code;
	private String msg;
	private T result;
	
	public Result(){}
	
	public Result(ResultCode code){
		this.code = code.getCode();
		this.msg = code.getMsg();
	}
	
	public Result(ResultCode code,T data){
		this(code);
		this.result = data;
	}
}
