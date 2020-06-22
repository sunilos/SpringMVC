package com.sunilos.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunilos.dao.MarksheetDAOInt;
import com.sunilos.dto.MarksheetDTO;
import com.sunilos.exception.ApplicationException;
import com.sunilos.exception.DuplicateRecordException;

/**
 * Service class contains Marksheet module business logics. It does
 * transactional handling with help of Spring AOP.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Service("marksheetService")
public class MarksheetServiceImpl implements MarksheetServiceInt {

	private static Logger log = Logger.getLogger(MarksheetServiceImpl.class);

	@Autowired
	private MarksheetDAOInt marksheetDAO;

	/**
	 * Adds a Marksheet.
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(MarksheetDTO dto) {

		MarksheetDTO duplicateDTO = get(dto.getRollNo());
		if (duplicateDTO != null) {
			throw new DuplicateRecordException("RollNo is already exist.");
		}
		long pk = 0;

		try {
			pk = marksheetDAO.add(dto);
		} catch (Exception e) {
			throw new ApplicationException("Exception in Marksheet Add "
					+ e.getMessage());
		}

		return pk;
	}

	/**
	 * Updates Marksheet
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(MarksheetDTO dto) {

		MarksheetDTO duplicateDTO = get(dto.getRollNo());
		if (duplicateDTO != null && duplicateDTO.getId() != dto.getId()) {
			throw new DuplicateRecordException("Marksheet is already exist.");
		}
		try {
			marksheetDAO.update(dto);
		} catch (Exception e) {
			log.error(e);
			throw new ApplicationException("Exception in Marksheet update "
					+ e.getMessage());
		}
	}

	/**
	 * Deletes a Marksheet
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public MarksheetDTO delete(long id) {
		MarksheetDTO dto = null;

		try {
			dto = marksheetDAO.delete(id);
		} catch (Exception e) {
			throw new ApplicationException("Exception in Marksheet Delete"
					+ e.getMessage());
		}
		return dto;
	}

	/**
	 * Search a Marksheet. It applies pagination.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		return marksheetDAO.search(dto, pageNo, pageSize);
	}

	/**
	 * Finds a Marksheet by its ID
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public MarksheetDTO get(long id) {
		return marksheetDAO.findByPK(id);
	}

	public MarksheetDTO get(String rollNo) {
		return marksheetDAO.findByRollNo(rollNo);
	}

}
