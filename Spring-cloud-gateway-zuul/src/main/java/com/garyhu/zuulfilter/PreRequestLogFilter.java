package com.garyhu.zuulfilter;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 自定义的zuul过滤器
 * @author garyhu
 *
 */
public class PreRequestLogFilter extends ZuulFilter {

	private static final Logger LOGGER = Logger.getLogger(PreRequestLogFilter.class);
	
	@Override
	public Object run() {
		// 过滤器的具体逻辑
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s",
				request.getMethod(),request.getRequestURL().toString()));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 返回一个boolean值来判断该过滤器是否要执行，true表示执行，false表示不执行
		return true;
	}

	@Override
	public int filterOrder() {
		// 返回一个int值来指定过滤器执行的顺序，不同的过滤器允许返回相同的数字
		return 1;
	}

	@Override
	public String filterType() {
		// 返回过滤器的类型
		// 类型可选pre,route,post,error
		return "pre";
	}

}
