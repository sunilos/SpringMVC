package com.sunilos.form;

import java.sql.Timestamp;

import com.sunilos.dto.BaseDTO;

/**
 * Base form bean contains generic attributes.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public abstract class BaseForm {

	/**
	 * Primary Key
	 */
	protected long id = 0;

	protected String createdBy;
	protected String modifiedBy;
	protected long createdDatetime = 0;
	protected long modifiedDatetime = 0;

	/**
	 * Primary keys collected from list page in case of multiple selection.
	 */
	private long[] ids;

	/**
	 * List page current page number
	 */
	protected int pageNo = 1;

	/**
	 * Number of records to be displayed on a page.
	 */
	protected int pageSize = 10;

	/**
	 * Value of button clicked on a View
	 */
	protected String operation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public long getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(long createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public long getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(long modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	/**
	 * Populates DTO from Formbean.
	 * 
	 * @param baseDto
	 * @return
	 */
	public BaseDTO getDTO(BaseDTO baseDto) {
		baseDto.setId(id);
		baseDto.setCreatedBy(createdBy);
		baseDto.setModifiedBy(modifiedBy);
		baseDto.setCreatedDatetime(new Timestamp(createdDatetime));
		baseDto.setModifiedDatetime(new Timestamp(modifiedDatetime));
		return baseDto;
	}

	/**
	 * Populates Frombean from DTO.
	 * 
	 * @param baseDto
	 */
	public void populateForm(BaseDTO baseDto) {

		id = baseDto.getId();
		modifiedBy = baseDto.getModifiedBy();
		createdBy = baseDto.getCreatedBy();

		if (baseDto.getCreatedDatetime() != null) {
			createdDatetime = baseDto.getCreatedDatetime().getTime();
		}

		if (baseDto.getModifiedDatetime() != null) {
			modifiedDatetime = baseDto.getModifiedDatetime().getTime();
		}

	}

}
