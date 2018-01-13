package com.garyhu.common;

import lombok.Data;

@Data
public class Result<T> {

	private int code;
	private String msg;
	private T result;
	
	public Result(){}
	
	public Result(ResultCode code,T data){
		this(code);
		this.result = data;
	}
	
	public Result(ResultCode resultCode){
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
	}
}
