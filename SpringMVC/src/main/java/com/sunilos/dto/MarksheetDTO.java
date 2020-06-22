package com.sunilos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Hibetnate persistent object. Binds Marskheet DTO to ST_MARKSHEET table. It
 * usess hibernate 3.0 annotations configuration instead of .hbm.xml based
 * configuration.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Entity
@Table(name = "SOS_marksheet")
public class MarksheetDTO extends BaseDTO {

	@Column(name = "ROLL_NO", length = 20)
	private String rollNo;

	@Column(name = "NAME", length = 5)
	private String name;

	@Column(name = "PHYSICS", length = 5)
	private Integer physics;

	@Column(name = "CHEMISTRY", length = 5)
	private Integer chemistry;

	@Column(name = "MATHS", length = 5)
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

}
