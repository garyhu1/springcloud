package com.garyhu.util;

public class ResponseUtil {

	public static Result success(Object o,String msg){
		return new Result(ResultCode.SUCCESS,o);
	}
	
	public static Result warn(ResultCode code){
		return new Result(code);
	}
}
