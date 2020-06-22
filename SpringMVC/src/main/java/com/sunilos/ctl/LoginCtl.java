package com.sunilos.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunilos.dto.UserDTO;

/**
 * Login Controller contains before login navigation.
 * 
 * 
 * @version 1.0
 * @since 1 Jan 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@Controller
@RequestMapping(value = "/Login")
public class LoginCtl {

	/**
	 * Display Login page
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String login(@RequestParam(required = false) String operation,
			@RequestParam(required = false) String message,
			@ModelAttribute("user") UserDTO user, Model model) {

		if (message != null) {
			model.addAttribute("message", message);
		}
		System.out.println("I am in login");
		
		return "Login";
	}

	/**
	 * Submit Login Page
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginSubmit(HttpSession session,
			@RequestParam(required = true) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {

		System.out.println("I am in login Submit");
		System.out.println("Operation : " + operation);
		System.out.println("Login : " + user.getLogin());
		System.out.println("Password : " + user.getPassword());

		/**
		 * New user Sign Up
		 */
		if ("SignUp".equals(operation)) {
			return "redirect:register";
		}

		if ("admin".equals(user.getLogin())
				&& "admin".equals(user.getPassword())) {
			session.setAttribute("userContext", user);
			return "redirect:/User/search";
		} else {
			model.addAttribute("error", "Invalid ID/Password");
			return "Login";
		}
	}

	/**
	 * Display User registration page
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUser(
			@RequestParam(required = false) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {
		System.out.println("I am in user registration");
		return "Registration";
	}

	/**
	 * Submit User registration page
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUserSubmit(
			@RequestParam(required = true) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {

		System.out.println("I am in user registration");
		System.out.println("Operation : " + operation);
		System.out.println("First Name : " + user.getFirstName());
		System.out.println("Last Name : " + user.getLastName());
		System.out.println("Login : " + user.getLogin());
		System.out.println("Password : " + user.getPassword());

		model.addAttribute("message",
				"Congratulations! You have been successfully registered, please login here");

		return "redirect:";
	}

	/**
	 * Display Forgot Password page
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(
			@RequestParam(required = false) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {
		System.out.println("I am in user forgotPassword");
		return "ForgotPassword";
	}

	/**
	 * Submit Forgot Password
	 * 
	 * @param operation
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String forgotPasswordSubmit(
			@RequestParam(required = true) String operation,
			@ModelAttribute("user") UserDTO user, Model model) {

		System.out.println("I am in user forgot password submit");
		System.out.println("Operation : " + operation);
		System.out.println("Login : " + user.getLogin());

		if ("Sign In".equals(operation)) {
			System.out.println("11111");
			return "redirect:/Login";
		} else {
			model.addAttribute("message",
					"Your password has been sent to your Email ID!!");

			return "ForgotPassword";

		}

	}
}
