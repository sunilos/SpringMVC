package com.sunilos.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurred.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class ApplicationException extends RuntimeException {

	/**
	 * @param msg
	 *            : Error message
	 */
	public ApplicationException(String msg) {
		super(msg);
	}
}