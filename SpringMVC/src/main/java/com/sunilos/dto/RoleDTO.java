package com.sunilos.dto;

/**
 * Role JavaBean encapsulates role attributes
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class RoleDTO extends BaseDTO {

	/**
	 * Role Name
	 */
	private String name;

	/**
	 * Role Description
	 */
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
