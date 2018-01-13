package com.garyhu.common;

public enum ResultCode {

	SUCCESS(200,"请求成功"),
	NO_DATA(3201,"没有数据"),
	ERROR(4101,"找不到该页面"),
	PARAMS_ERROR(3202,"参数非法");
	
	private int code;
	private String msg;
	
	ResultCode(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getMsg(){
		return this.msg;
	}
}
