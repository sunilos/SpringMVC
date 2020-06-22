package com.sunilos.form;

/**
 * Simple POJO class that will be bound with Request parameters with help of
 * annotation @ModelAttribute() in a controller.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class LoginSimpleForm {

	/**
	 * Login Id if a User
	 */
	private String login = null;

	/**
	 * Password of a User
	 */
	private String password = null;

	/**
	 * Contains success or fail message
	 */
	private String message = null;

	/**
	 * Value of clicked button.
	 */
	private String operation = null;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
