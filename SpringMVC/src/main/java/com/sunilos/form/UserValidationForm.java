package com.sunilos.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple POJO class that will be bound with Request parameters. It applies
 * input validations with help of (1) Bean Validation API 1.1 and (2)Hibernate
 * Validator 5.0.1.Final annotations.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class UserValidationForm {

	@Min(value = 1, message = "Id must be a positive number.")
	private long id = 0L;

	@NotNull(message = "First Name can not be Null.")
	@Size(min = 5, max = 50)
	private String firstName = null;

	@NotNull(message = "Last Name can not be Null.")
	@Size(min = 5, max = 50)
	private String lastName = null;

	@NotNull(message = "Gender can not be Null.")
	@Size(min = 1, max = 6)
	private String gender = null;

	@Min(value = 13, message = "Age must be beatween 13-90.")
	@Max(value = 90, message = "Age must be beatween 13-90.")
	int age = 0;

	@NotNull(message = "DOB can not be Null.")
	private Date dateOfBirth = new Date();

	@NotNull(message = "Mobile can not be Null.")
	@Pattern(regexp = "^[0-9]+", message = "Mobile number will have only digits.")
	@Size(min = 10, max = 10, message = "Mobile No Must be of 10 digits.")
	private String mobileNo = null;

	@Email(message = "Invalid Email ID.")
	private String email = null;

	@URL(message = "Invalid URL")
	private String url = null;

	private String operation = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
