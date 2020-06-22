package com.sunilos.ctl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * This Interceptor intercepts incoming requests at URI patteren "/UrlMapping/*"
 * and log the pre and post processing time-stamp
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class TimeLoggerInt extends HandlerInterceptorAdapter {

	/**
	 * Called before request is executed by target controller.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		System.out.println("TimeLoggerInt:  preHandle()  : " + new Date());
		System.out.println("request uri is :: " + request.getRequestURI());

		return true;
	}

	/**
	 * Called after request is executed by target controller.
	 */

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TimeLoggerInt: postHandle() ! " + new Date());
	}

	/**
	 * Called when request processing is completely done.
	 */

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TimeLoggerInt: after Completion() ! " + new Date());
	}
}
