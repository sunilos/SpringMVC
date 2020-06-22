package com.sunilos.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Validation error messages is fached from i18n Message resource
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class LocaleForm {

	@NotEmpty
	@Size(min=5, max=20)
	private String name =null;
	
	private String lang =null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	
}
