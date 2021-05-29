package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCORSFilter implements Filter{

	private final Log logger = LogFactory.getLog(this.getClass());
	
	@Override
	public void init(FilterConfig fc){
		logger.info("HespDesk-API | SimpleCORSFilter loaded");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Acces-Control-Allow-Origin", "*");
		response.setHeader("Acces-Control-Allow-Origin", "POST, GET, OPTIONS, DELETE, PUT");
		response.setHeader("Acces-Control-Allow-Origin", "3600");
		response.setHeader("Acces-Control-Allow-Origin", "ed-with, authorization, Content-Type, Authorization");
		
		if("OPTIONS".equalsIgnoreCase(request.getMethod())){
			response.setStatus(HttpServletResponse.SC_OK);
		} else{
			chain.doFilter(req, resp);
		}
		
	}
	@Override
	public void destroy(){
		
	}

	
}
