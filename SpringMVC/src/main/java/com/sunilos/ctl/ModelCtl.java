package com.sunilos.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * This Controller is an example of how to use different kind of Models to send
 * and receive data from View.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
@RequestMapping(value = "/ModelCtl")
public class ModelCtl {

	/**
	 * This method will always be called for this controller whether any method
	 * is called.
	 * 
	 * This kind or mapping is used for Pre-Loaded data.
	 * 
	 * @param operation
	 * @param model
	 */

	@ModelAttribute
	public void prepare(Model model) {
		model.addAttribute("preload", "This is preloaded message");
	}

	/**
	 * Creates and returns an object of ModelAndView. It cotains model
	 * attributes that will be carried to View and name of View that is resolved
	 * by ViewResolver
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ModelAndView", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ModelView");
		model.addObject("message",
				"This message is set to ModelAndView object.");
		return model;
	}

	/**
	 * Receives Model as parameter and returnes View name
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Model", method = RequestMethod.GET)
	public String display(Model model) {
		model.addAttribute("message",
				"This message is set to <b>Model<b> object.");
		return "ModelView";
	}

	/**
	 * Binds request parameters to method parameters with help of @RequestParam
	 * 
	 * @return
	 */
	@RequestMapping( value = "/Submit", method = RequestMethod.POST)
	public String submit(@RequestParam String name, @RequestParam int age,
			Model model) {

		String msg = "Your name is " + name + " and age is " + age;

		model.addAttribute("message", msg);

		return "ModelView";
	}

}
