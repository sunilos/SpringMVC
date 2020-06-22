package com.sunilos.ctl;

import java.util.HashMap;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunilos.form.LocaleForm;

/**
 * 
 * En example of i18n and L10n.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
@RequestMapping(value = "/Locale")
public class LocaleCtl {

	@Autowired
	private MessageSource messageSource;

	/**
	 * Preload Language List
	 * @param model
	 */
	@ModelAttribute
	public void preLoad(Model model) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("hi", "Hindi");
		map.put("en", "English");

		model.addAttribute("map", map);
	}

	/**
	 * Handles GET request for /Locale url
	 * 
	 * @param model
	 *            - Will take data from Controller to Model.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@ModelAttribute("localeForm") @Valid LocaleForm form,
			BindingResult bindingResult, Model model, Locale locale) {

		model.addAttribute("welcome", "Welcome to i18n/L10n Spring MVC!!");

		String msg = messageSource.getMessage("message.ctl", null, locale);

		model.addAttribute("message", msg);

		return "LocaleView";
	}

}
