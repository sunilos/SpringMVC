package com.sunilos.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.dto.BaseDTO;
import com.sunilos.dto.CollegeDTO;

/**
 * College form bean contains attributes, bound with College View.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class CollegeForm extends BaseForm {

	@NotEmpty(message = "Name Can't be Null")
	private String name;
	@NotEmpty
	private String address;
	@NotEmpty
	private String state;
	@NotEmpty
	private String city;

	@NotNull(message = "Mobile can not be Null.")
	@Pattern(regexp = "^[0-9]+", message = "Mobile number will have only digits.")
	@Size(min = 10, max = 10, message = "Mobile No Must be of 10 digits.")
	private String phoneNo;

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Populates CollegeDTO attributes from Formbean attributes.
	 */
	@Override
	public BaseDTO getDTO(BaseDTO baseDto) {
		CollegeDTO dto = (CollegeDTO) baseDto;
		dto.setName(name);
		dto.setAddress(address);
		dto.setCity(city);
		dto.setState(state);
		dto.setPhoneNo(phoneNo);
		return super.getDTO(dto);
	}

	/**
	 * Populates Formbean attributes from CollegeDTO attributes.
	 */
	@Override
	public void populateForm(BaseDTO baseDto) {
		if (baseDto == null) {
			return;
		}
		CollegeDTO dto = (CollegeDTO) baseDto;
		id = dto.getId();
		name = dto.getName();
		address = dto.getAddress();
		city = dto.getCity();
		state = dto.getState();
		phoneNo = dto.getPhoneNo();
		super.populateForm(dto);
	}

}
