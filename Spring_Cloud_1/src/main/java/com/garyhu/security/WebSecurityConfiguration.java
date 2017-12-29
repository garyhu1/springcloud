package com.garyhu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http)throws Exception{
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		//明文编码器。这是一个不做任何操作的密码编辑器，是spring提供给我们做明文测试的
		return NoOpPasswordEncoder.getInstance();
	}
	
//	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
//		auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
	}
}
