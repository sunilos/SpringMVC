package com.sunilos.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Front controller intercepts all incoming requests and check if user is logged
 * in. If user is not logged in then it will redirect page to Login View.
 * 
 * It is mapped to URI "/*".
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class FrontCtlInt extends HandlerInterceptorAdapter {

	/**
	 * If false value is returned then further execution chain will be stopped
	 * and you have to redirect your page to the target page.
	 * 
	 * It is called before request is executed by target controller.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		System.out.println("FrontCtlInt:  preHandle() Started");
		System.out.println("request uri is :: " + request.getRequestURI());

		if (session.getAttribute("user") == null) {

			System.out.println("FrontCtlInt: User is not logged in ");

			/*
			 * If user is not logged then forward it Login page and return false
			 * value to interceptor. I
			 */

			// response.sendRedirect("Login.html");
			// return false;

			return true;

		} else {
			System.out.println("FrontCtlInt: User is logged in");
		}

		System.out.println("FrontCtlInt:  preHandle() finished");

		return true;
	}

	/**
	 * Called after request is executed by target controller.
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("FrontCtlInt: postHandle() ! ");
	}

	/**
	 * Called when request processing is completely done.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("FrontCtlInt: after Completion() ! ");
	}

}
