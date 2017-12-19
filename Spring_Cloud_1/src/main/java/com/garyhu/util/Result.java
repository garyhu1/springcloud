package com.garyhu.util;

import lombok.Data;

@Data
public class Result<T> {

	private int code;
	private String msg;
	private T result;
	
	public Result() {
    }

    public Result(ResultCode resultCode, T data) {
        this(resultCode);
        this.result = data;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
}
