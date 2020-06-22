package com.sunilos.ctl;

import org.springframework.ui.Model;

/**
 * Base controller, extended by all controllers.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class BaseCtl {

	/**
	 * Generic operations on the View
	 */

	public static final String OP_SAVE = "Save";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_DELETE = "Delete";
	public static final String OP_LIST = "List";
	public static final String OP_SEARCH = "Search";
	public static final String OP_VIEW = "View";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "Previous";
	public static final String OP_NEW = "New";
	public static final String OP_GO = "Go";
	public static final String OP_BACK = "Back";
	public static final String OP_LOG_OUT = "Logout";

	/**
	 * Loads list and other data required to display at HTML form
	 * 
	 * @param model
	 */
	public void preload(Model model) {
	}
}
