package com.sunilos.service;

import java.util.List;

import com.sunilos.dto.MarksheetDTO;

/**
 * Marksheet Service interface.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface MarksheetServiceInt {

	/**
	 * Adds a Marksheet
	 * 
	 * @param dto
	 * @return
	 */
	public long add(MarksheetDTO dto);

	/**
	 * Updates a Marksheet
	 * 
	 * @param dto
	 */
	public void update(MarksheetDTO dto);

	/**
	 * Deletes a Marksheet
	 * 
	 * @param id
	 * @return
	 */
	public MarksheetDTO delete(long id);

	/**
	 * Searches Marksheet
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize);

	/**
	 * Gets a Marksheet by its ID
	 * 
	 * @param id
	 * @return
	 */
	public MarksheetDTO get(long id);

	/**
	 * Gets a Marksheet by its name.
	 * 
	 * @param name
	 * @return
	 */
	public MarksheetDTO get(String rollNo);
}
