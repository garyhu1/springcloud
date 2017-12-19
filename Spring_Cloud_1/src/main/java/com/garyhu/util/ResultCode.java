package com.garyhu.util;

public enum ResultCode {

	SUCCESS(200, "请求成功"),
    WEAK_NET_WORK(3001, "网络异常，请稍后重试"),
    PAGE_ERROR(3002, "网页有误"),
    PASSWORD_ERROR(10001, "用户名或密码错误"),
    PARAMETER_ERROR(10101, "参数错误");
	
	private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
