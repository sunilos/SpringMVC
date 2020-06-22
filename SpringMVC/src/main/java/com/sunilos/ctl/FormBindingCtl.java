package com.sunilos.ctl;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunilos.form.LoginSimpleForm;
import com.sunilos.form.UserValidationForm;

/**
 * This Controller binds request parameters to the Form Bean with the help of
 * annotation @ModelAttribute("form").
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Controller
@RequestMapping(value = "/FormBinding")
public class FormBindingCtl {

	/**
	 * Annotation @ModelAttribute("loginForm") is used to bind request
	 * parameters to a form-bean object. Form-bean object is added in Model map
	 * with "loginForm" key. This key name is used in View to bind this
	 * form-bean object to HTML form elements using following tag.
	 * 
	 * <f:form action="../FormBinding/login" commandName="loginForm">
	 * 
	 * <f:input path="login" />
	 * 
	 * <f:password path="password" />
	 * 
	 * </f:form>
	 * 
	 * 
	 * @return View name
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginDisplay(
			@ModelAttribute("loginForm") LoginSimpleForm form, Model model) {

		return "LoginBindingView";
	}

	/**
	 * Handls POST request and binds request parameter to LoginForm object and
	 * keeps in Model Map.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(
			@ModelAttribute("loginForm") LoginSimpleForm form, Model model) {

		String message = "You entered Login: " + form.getLogin()
				+ " and Password: " + form.getPassword();

		form.setMessage(message);

		return "LoginBindingView";
	}

	/**
	 * Handels GET request, sent to "/FormBinding/user" url path. It creates
	 * UserForm bean object and binds request parameters and add this object
	 * into Model map using .
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userDisplay(
			@ModelAttribute("userForm") UserValidationForm form, Model model) {
		return "UserBindingView";
	}

	/**
	 * Handels POST request, sent to "/FormBinding/user" url path. It creates
	 * UserForm bean object and binds request parameters and add this object
	 * into Model map using.
	 * 
	 * Annotation @Valid is used to apply input validations to UserForm bean. If
	 * input validations are failed then BindingResult object contains input
	 * error messages.
	 * 
	 * UserForm is bind with HTML form and error messages are displayed using
	 * following tags:
	 * 
	 * <f:form action="../FormBinding/user" method="post"
	 * commandName="userForm">
	 * <table>
	 * <tr>
	 * <td>ID</td>
	 * <td><f:input path="id" /> <f:errors path="id" cssClass="error" /></td>
	 * </tr>
	 * </table>
	 * </f:form>
	 * 
	 * @param userFrom
	 *            : binds request parameters
	 * @param result
	 *            has errors if input validations are fail.
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String userSubmit(
			@ModelAttribute("userForm") @Valid UserValidationForm userFrom,
			BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("error", "Input validation error!");

			List<ObjectError> l = result.getAllErrors();
			for (ObjectError e : l) {
				System.out.println(e.getObjectName() + "-" + e.getCode() + "-"
						+ e.getDefaultMessage());
			}

		} else {

			String message = "Entered user name is " + userFrom.getFirstName()
					+ " " + userFrom.getLastName();
			model.addAttribute("message", message);
		}

		System.out.println("I am in post" + userFrom.getDateOfBirth());
		return "UserBindingView";
	}

	/**
	 * Custom binder that converts string into Date object and Date object into
	 * String when request parameter is bound to Date object.
	 * 
	 * Here it converts formatted string "dd/MM/yyyy" into Date and vice versa.
	 * 
	 * @param binder
	 */
	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

			/**
			 * String to Date conversion
			 */
			public void setAsText(String value) {
				try {
					setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
				} catch (ParseException e) {
					setValue(null);
				}
			}

			/**
			 * Date to String conversion
			 */
			public String getAsText() {
				return new SimpleDateFormat("dd/MM/yyyy")
						.format((Date) getValue());
			}

		});
	}
}
