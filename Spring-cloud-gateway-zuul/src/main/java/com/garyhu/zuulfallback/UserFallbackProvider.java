package com.garyhu.zuulfallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 为zuul添加回退类
 * @author garyhu
 *
 */
@Component
public class UserFallbackProvider implements ZuulFallbackProvider {

	@Override
	public String getRoute() {
		// 表明是为哪个微服务提供回退
		return "springcloud2";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				// headers的设定
				HttpHeaders headers = new HttpHeaders();
				MediaType mt = new MediaType("application","json",Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				// 响应体
				return new ByteArrayInputStream("用户微服务不可用，请稍后再试。".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				// 状态文本，本例返回的其实就是OK，详见HttpStatus
				return this.getStatusCode().getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				// fallback时的状态码
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// 数字类型的状态码，本例返回的其实是200，详见HttpStatus
				return this.getStatusCode().value();
			}
			
			@Override
			public void close() {
			}
		};
	}

}
