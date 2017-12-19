package com.garyhu.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.garyhu.util.ResponseUtil;
import com.garyhu.util.Result;
import com.garyhu.util.ResultCode;

@Controller
@RequestMapping("${spring.error.path:${error.path:/error}}")
public class MyErrorException implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	@RequestMapping
	@ResponseBody
	public Result error(){
		return ResponseUtil.warn(ResultCode.PAGE_ERROR);
	}
}
