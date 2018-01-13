package com.garyhu.common;

public class ResponseUtil {

	public static Result success(Object o){
		return new Result(ResultCode.SUCCESS,o);
	}
	
	public static Result warn(ResultCode resultCode){
		return new Result(resultCode);
	}
}
