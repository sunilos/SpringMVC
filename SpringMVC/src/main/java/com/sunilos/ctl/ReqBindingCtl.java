package com.sunilos.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Binds request parameters to method arguments.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
// URL /UrlMapping is mapped with entire class
@RequestMapping(value = "/ReqBinding")
public class ReqBindingCtl {

	/**
	 * Example method to receive request parameter using @RequestParam
	 * annotation.
	 * 
	 * Using @RequestParam annotation you can receive as many parameters as you
	 * want.
	 * 
	 * Use http://localhost:8080/STMavenSpringMVC/UrlMapping/param
	 * 
	 * @return View Name
	 */

	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String requestParam(@RequestParam String message, Model model) {
		model.addAttribute("message", "Request Parameter : " + message);
		return "ReqBindingView";
	}

	/**
	 * Specifies request parameter name.
	 * 
	 * @param message
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/param1", method = RequestMethod.GET)
	public String requestParam1(@RequestParam("message") String message,
			Model model) {
		model.addAttribute("message", "Request Parameter : " + message);
		return "ReqBindingView";
	}

	/**
	 * Specifies request parameter name using annotation attribute name.
	 * 
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/param2", method = RequestMethod.GET)
	public String requestParam2(

	@RequestParam(value = "message") String message, Model model) {
		model.addAttribute("message", "Request Parameter : " + message);
		return "ReqBindingView";
	}

	/**
	 * Request and Method parameter names are different.
	 * 
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/param3", method = RequestMethod.GET)
	public String requestParam3(@RequestParam("msg") String message, Model model) {
		model.addAttribute("message", "Request Parameter : " + message);
		return "ReqBindingView";
	}

	/**
	 * Makes request parameter optional
	 * 
	 * @param message
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/param4", method = RequestMethod.GET)
	public String requestParam4(
			@RequestParam(value = "message", required = false) String message,
			Model model) {
		model.addAttribute("message", "Request Parameter : " + message);
		return "ReqBindingView";
	}

	/**
	 * Type converstion
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/param5", method = RequestMethod.GET)
	public String requestParam5(
			@RequestParam(value = "id", required = false) long id, Model model) {
		model.addAttribute("message", "Request Parameter : " + id);
		return "ReqBindingView";
	}

}
