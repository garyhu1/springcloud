package com.garyhu.util;

public enum ResultCode {

	SUCCESS (200,"操作成功"),
	PAGE_ERROR (3001,"网页出错");
	
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
