package com.sunilos.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

/**
 * 
 * A Simple example Controller and Model.
 * 
 * Controller class is mapped to URL /Welcome. Request is sent to this
 * Controller by http://localhost:8080/yourapp/Welcome
 * 
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
@RequestMapping(value = "/Welcome")
public class WelcomeCtl {

	/**
	 * Handles GET request for /Welcome url
	 * 
	 * @param model
	 *            - Will take data from Controller to Model.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(Model model) {
		System.out.println("I am in display");
		model.addAttribute("message", "Welcome to Spring MVC!!");
		return "Welcome";
	}

	/**
	 * Handles POST request for /Welcome url
	 * 
	 * @param model
	 *            - Will take data from Controller to Model.
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model) {
		System.out.println("I am in submit");
		model.addAttribute("message", "You sent post request!");
		return "Welcome";
	}

}
