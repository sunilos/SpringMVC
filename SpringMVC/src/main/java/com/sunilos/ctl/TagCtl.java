package com.sunilos.ctl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunilos.dto.RoleDTO;
import com.sunilos.form.TagForm;

/**
 * Controller to explain HTML tag data bibding and its rendiring using Array,
 * Collection and Map.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
@RequestMapping(value = "/Tag")
public class TagCtl {

	@ModelAttribute
	public void preLoad(@ModelAttribute("tagForm") TagForm form, Model model) {

		// Set Boolean value
		form.setAgreed(true);

		// Set list of elements as Array
		String[] str = { "Java", "PHP", "Android" };
		model.addAttribute("skillArray", str);

		// Create Collection
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("BE");
		courses.add("MCA");
		courses.add("MBA");
		model.addAttribute("coursesList", courses);

		// Create Map
		HashMap<String, String> languages = new HashMap<String, String>();
		languages.put("en", "English");
		languages.put("hi", "Hindi");
		languages.put("sp", "Spanish");

		model.addAttribute("languagesMap", languages);

		ArrayList<RoleDTO> roleList = new ArrayList<RoleDTO>();

		RoleDTO role1 = new RoleDTO();
		role1.setId(1);
		role1.setName("Admin");
		roleList.add(role1);

		RoleDTO role2 = new RoleDTO();
		role2.setId(2);
		role2.setName("Manger");
		roleList.add(role2);

		RoleDTO role3 = new RoleDTO();
		role3.setId(2);
		role3.setName("Customer");
		roleList.add(role3);

		model.addAttribute("roleList", roleList);

	}

	/**
	 * Handles GET request for /Tag url
	 * 
	 * @param model
	 *            - Will take data from Controller to Model.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@ModelAttribute("tagForm") TagForm form, Model model) {

		form.displayValues();
		return "TagView";
	}

}
