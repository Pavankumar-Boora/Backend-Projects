package com.learning.filter;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HeaderFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String xHeader = httpRequest.getHeader("X-Header");
		
		if (xHeader == null || xHeader.isEmpty()) {
			String uid = UUID.randomUUID().toString();
			httpResponse.addHeader("X-Header", uid);
			System.out.println("X-Header not found. Added UID: " + uid);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
//		Filter.super.destroy();
	}
}
