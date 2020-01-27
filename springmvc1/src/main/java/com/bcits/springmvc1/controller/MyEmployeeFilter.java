package com.bcits.springmvc1.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(urlPatterns = "/*")
public class MyEmployeeFilter implements Filter{
	
@Override
public void init(FilterConfig config)throws ServletException{
	
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	HttpServletRequest req=(HttpServletRequest) request;
	System.out.println("inside filter");
	System.out.println("URL is:"+req.getRequestURI());
	
	System.out.println("URI"+req.getRequestURI());
	chain.doFilter(request, response);
	
}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}
 
}
