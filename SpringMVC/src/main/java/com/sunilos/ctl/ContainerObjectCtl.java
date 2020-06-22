package com.sunilos.ctl;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * This Controller is an example of passing Container objects HttpSession,
 * HttpServletRequest, HttpServletResponse to controller methods as aurguments.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
@RequestMapping(value = "/ContainerObj")
public class ContainerObjectCtl {

	/**
	 * Sends request and response objects as method argument.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Request", method = RequestMethod.GET)
	public String injectRequest(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		request.setAttribute("request.one", "Value One" + new Date());
		request.setAttribute("request.two", "Value Two" + new Date());

		return "ContainerObjectView";
	}

	/**
	 * Sends session object as method argument.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Session", method = RequestMethod.GET)
	public String injectSession(HttpSession session, Model model) {

		session.setAttribute("session.one", "Value One" + new Date());
		session.setAttribute("session.two", "Value Two" + new Date());

		ServletContext application = session.getServletContext();

		application.setAttribute("application.one", "Value One" + new Date());
		application.setAttribute("application.two", "Value Two" + new Date());

		return "ContainerObjectView";
	}

	/**
	 * Sends request, response, and session objects as method argument.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String injectAll(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) {

		request.setAttribute("request.one", "Value One" + new Date());
		request.setAttribute("request.two", "Value Two" + new Date());

		session.setAttribute("session.one", "Value One" + new Date());
		session.setAttribute("session.two", "Value Two" + new Date());

		ServletContext application = session.getServletContext();

		application.setAttribute("application.one", "Value One" + new Date());
		application.setAttribute("application.two", "Value Two" + new Date());

		return "ContainerObjectView";
	}

}
