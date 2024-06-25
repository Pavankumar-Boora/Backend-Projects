package com.learning.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.filter.HeaderFilter;


@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<HeaderFilter> headerFilter(){
		FilterRegistrationBean<HeaderFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new HeaderFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
