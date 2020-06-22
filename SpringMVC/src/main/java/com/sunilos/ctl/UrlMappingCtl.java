package com.sunilos.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * An exanple that maps URLs with controller class and its methods. A controller
 * class or its individual methods are mapped with URL using @RequestMapping
 * annotation.
 * 
 * Mapping can be bind with HTTP POST and GET methods.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
// URL /UrlMapping is mapped with entire class
@RequestMapping(value = "/UrlMapping")
public class UrlMappingCtl {

	/**
	 * HTTP GET method is bound with display() method. URL to call this method
	 * will be http://localhost:8080/STMavenSpringMVC/UrlMapping is called from
	 * browser.
	 * 
	 * @return View Name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display() {
		System.out.println("I am in display method");
		return "UrlMappingView";
	}

	/**
	 * HTTP POST method is bound with submit() method. This method will be
	 * called when data is submitted to action="/UrlMapping" from a HTML FORM
	 * using POST method.
	 * 
	 * <form action="/UrlMapping" method="POST" >...</form>
	 * 
	 * @return View Name
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String submit() {
		System.out.println("I am in submit method");
		return "UrlMappingView";
	}

	/**
	 * 
	 * Methos is bind with relatice url "/search", that maps method with
	 * "/UrlMapping/search" URL.
	 * 
	 * HTTP POST and GET both methods are bound to search() method.
	 * 
	 * 
	 * @return View Name
	 */

	@RequestMapping(value = "/search", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String search() {
		System.out
				.println("I am in search method, it handles GET and POST methods.");
		return "TestSearchView";
	}

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
	public String requestParam(@RequestParam String message) {
		System.out.println("Request Parameter : " + message);
		return "UrlMappingView";
	}

	@RequestMapping(value = "/param1", method = RequestMethod.GET)
	public String requestParam1(@RequestParam("message") String message) {
		System.out.println("Request Parameter : " + message);
		return "UrlMappingView";
	}

	@RequestMapping(value = "/param2", method = RequestMethod.GET)
	public String requestParam2(@RequestParam(value = "message") String message) {
		System.out.println("Request Parameter : " + message);
		return "UrlMappingView";
	}

	@RequestMapping(value = "/param3", method = RequestMethod.GET)
	public String requestParam3(
			@RequestParam(value = "message", required = false) String message) {
		System.out.println("Request Parameter : " + message);
		return "UrlMappingView";
	}

	@RequestMapping(value = "/param4", method = RequestMethod.GET)
	public String requestParam4(
			@RequestParam(value = "id", required = false) long id) {
		System.out.println("Request Parameter : " + id);
		return "UrlMappingView";
	}

}
