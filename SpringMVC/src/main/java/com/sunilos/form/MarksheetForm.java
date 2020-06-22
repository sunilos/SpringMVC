package com.sunilos.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.dto.BaseDTO;
import com.sunilos.dto.MarksheetDTO;

/**
 * Marksheet form bean contains attributes, bound with College View.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class MarksheetForm extends BaseForm {

	@NotEmpty(message = "RollNo is required")
	private String rollNo;

	@NotEmpty(message = "Name is Required")
	private String name;

	@NotNull(message = "Should be integer between 0 to 100")
	@Min(0)
	@Max(100)
	private Integer physics;

	@NotNull(message = "Should be integer between 0 to 100")
	@Min(0)
	@Max(100)
	private Integer chemistry;

	@NotNull(message = "Should be integer between 0 to 100")
	@Min(0)
	@Max(100)
	private Integer maths;
	
	

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/**
	 * Populates MarksheetDTO attributes from Formbean attributes.
	 */
	@Override
	public BaseDTO getDTO(BaseDTO baseDto) {
		MarksheetDTO dto = (MarksheetDTO) baseDto;
		dto.setRollNo(rollNo);
		dto.setName(name);
		dto.setPhysics(physics);
		dto.setChemistry(chemistry);
		dto.setMaths(maths);
		return super.getDTO(dto);
	}

	/**
	 * Populates Formbean attributes from MarksheetDTO attributes.
	 */
	@Override
	public void populateForm(BaseDTO baseDto) {
		if (baseDto == null) {
			return;
		}
		MarksheetDTO dto = (MarksheetDTO) baseDto;
		rollNo =dto.getRollNo();
		name = dto.getName();
		physics = dto.getPhysics();
		chemistry = dto.getChemistry();
		maths = dto.getMaths();
		super.populateForm(dto);
	}

}
