package com.sunilos.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sunilos.dto.RoleDTO;
import com.sunilos.dto.UserDTO;

@Controller
@RequestMapping(value = "/User")
@SessionAttributes("userContext")
public class UserCtl {

	/**
	 * Preloaded data
	 * 
	 * @param number
	 * @param model
	 */

	@ModelAttribute
	public void prepare(@RequestParam(required = false) String operation,
			Model model) {

		System.out.println("Loding preloaded data Role List");

		List<RoleDTO> l = new ArrayList<RoleDTO>();

		RoleDTO admin = new RoleDTO();
		admin.setId(1);
		admin.setName("Admin");
		l.add(admin);

		RoleDTO member = new RoleDTO();
		admin.setId(2);
		admin.setName("Member");
		l.add(member);

		RoleDTO guest = new RoleDTO();
		admin.setId(3);
		admin.setName("Guest");
		l.add(guest);

		System.out.println("Size or Role List " + l.size());
		model.addAttribute("roleList", l);

	}

	/**
	 * View User Information
	 * 
	 * @param id
	 * @param operation
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewUser(@PathVariable("id") long id,
			@RequestParam(required = false) String operation, Model model) {

		System.out.println("I am in User View");
		System.out.println("User ID " + id);

		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setFirstName("Vijay");
		dto.setLastName("Chohan");
		dto.setLogin("vijay.chohan");

		model.addAttribute("user", dto);

		return "UserView";
	}

	/**
	 * Display User List
	 * 
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(required = false) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {
		System.out.println("I am in search");
		return "UserList";
	}

	/**
	 * Add User by Admin
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */

	@RequestMapping(value = { "/add/{id}", "/edit/{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable("id") long id,
			@RequestParam(required = false) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {
		System.out.println("I am in edit user ");

		if (id > 0) {
			user.setId(id);
			user.setFirstName("Vijay");
			user.setLastName("Chohan");
			user.setLogin("vijay.chohan");
		}
		return "User";
	}

	/**
	 * Submit User registration page
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editUserSubmit(
			@RequestParam(required = true) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {

		System.out.println("I am in user registration");
		System.out.println("Operation : " + operation);
		System.out.println("First Name : " + user.getFirstName());
		System.out.println("Last Name : " + user.getLastName());
		System.out.println("Login : " + user.getLogin());
		System.out.println("Password : " + user.getPassword());

		model.addAttribute("message",
				"Congratulations! User is successfully added.");

		return "User";
	}

}
