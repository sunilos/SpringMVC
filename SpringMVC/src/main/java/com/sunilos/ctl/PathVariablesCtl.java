package com.sunilos.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller binds URI template to method parameters.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
@RequestMapping(value = "/PathVariable")
public class PathVariablesCtl {

	/**
	 * Binds URI path {id} with method parameter.
	 * 
	 * @return View Name
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String singlePath(@PathVariable int id, Model model) {
		String message = "You have sent id : " + id + " as part of URL";
		model.addAttribute("message", message);
		return "PathVariableView";
	}

	/**
	 * Binds URI variable deptId and empId to method parameters.
	 * 
	 * @return View Name
	 */
	@RequestMapping(value = "/get/{deptId}/{empId}", method = RequestMethod.GET)
	public String multiplePath(@PathVariable int deptId,
			@PathVariable int empId, Model model) {
		String message = "You have sent Department ID : " + deptId
				+ " and Employee ID " + empId + " as part of URL";
		model.addAttribute("message", message);
		return "PathVariableView";
	}
}
