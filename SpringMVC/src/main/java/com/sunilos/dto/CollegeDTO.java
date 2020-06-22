package com.sunilos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Hibetnate persistent object. Binds College DTO to ST_COLLEGE table. It usess
 * hibernate 3.0 annotations configuration instead of .hbm.xml based
 * configuration.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Entity
@Table(name = "SOS_college")
public class CollegeDTO extends BaseDTO {
	
	/**
	 * Name of College
	 */
	@Column(name = "NAME", length = 100)
	private String name = null;

	/**
	 * Address of College
	 */
	@Column(name = "ADDRESS", length = 255)
	private String address = null;

	/**
	 * State of College
	 */
	@Column(name = "STATE", length = 20)
	private String state = null;

	/**
	 * City of College
	 */
	@Column(name = "CITY", length = 50)
	private String city = null;

	/**
	 * Phoneno of College
	 */
	@Column(name = "PHONE_NO", length = 15)
	private String phoneNo = null;

	/**
	 * accessor
	 */
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

}