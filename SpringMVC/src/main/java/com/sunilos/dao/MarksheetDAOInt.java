package com.sunilos.dao;

import java.util.List;

import com.sunilos.dto.MarksheetDTO;

/**
 * Data Access Object of Marksheet
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface MarksheetDAOInt {

	/**
	 * Adds a Marksheet.
	 * 
	 * @param dto
	 * @return
	 */
	public long add(MarksheetDTO dto);

	/**
	 * Updates a Marksheet.
	 * 
	 * @param dto
	 */
	public void update(MarksheetDTO dto);

	/**
	 * Deletes a Marksheet.
	 * 
	 * @param id
	 * @return
	 */
	public MarksheetDTO delete(long id);

	/**
	 * Finds Marksheet by ID.
	 * 
	 * @param id
	 * @return
	 */
	public MarksheetDTO findByPK(long id);

	/**
	 * Finds marksheet by RollNo.
	 * 
	 * @param RollNo
	 * @return
	 */
	public MarksheetDTO findByRollNo(String RollNo);

	/**
	 * Searches Marksheet with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize);

}
