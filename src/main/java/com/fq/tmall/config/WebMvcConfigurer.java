	

package com.fq.tmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fq.tmall.interceptor.LoginInterceptor;
import com.fq.tmall.interceptor.OtherInterceptor;

@Configuration
class WebMvcConfigurer extends WebMvcConfigurerAdapter{

	@Bean
	public OtherInterceptor getOtherIntercepter() {
		return new OtherInterceptor();
	}
	@Bean
	public LoginInterceptor getLoginIntercepter() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(getOtherIntercepter())
				.addPathPatterns("/**");
		registry.addInterceptor(getLoginIntercepter())
				.addPathPatterns("/**");
	}
}


