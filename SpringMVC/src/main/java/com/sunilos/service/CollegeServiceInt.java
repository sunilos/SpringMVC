package com.sunilos.service;

import java.util.List;

import com.sunilos.dto.CollegeDTO;

/**
 * College Service interface.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface CollegeServiceInt {

	/**
	 * Adds a College
	 * 
	 * @param dto
	 * @return
	 */
	public CollegeDTO add(CollegeDTO dto);

	/**
	 * Updates a College
	 * 
	 * @param dto
	 */
	public void update(CollegeDTO dto);

	/**
	 * Deletes a College
	 * 
	 * @param id
	 * @return
	 */
	public CollegeDTO delete(long id);

	/**
	 * Searches Colleges
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CollegeDTO> search(CollegeDTO dto, int pageNo, int pageSize);

	/**
	 * Gets a College by its ID
	 * 
	 * @param id
	 * @return
	 */
	public CollegeDTO get(long id);

	/**
	 * Gets a College by its name.
	 * 
	 * @param name
	 * @return
	 */
	public CollegeDTO get(String name);
}
