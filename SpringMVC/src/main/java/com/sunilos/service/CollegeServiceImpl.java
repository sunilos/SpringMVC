package com.sunilos.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunilos.dao.CollegeDAOInt;
import com.sunilos.dto.CollegeDTO;
import com.sunilos.exception.ApplicationException;
import com.sunilos.exception.DuplicateRecordException;

/**
 * Service class contains College module business logics. It does transactional
 * handling with help of Spring AOP.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Service("collegeService")
public class CollegeServiceImpl implements CollegeServiceInt {

	private static Logger log = Logger.getLogger(CollegeServiceImpl.class);

	@Autowired
	private CollegeDAOInt dao;

	/**
	 * Adds a College.
	 */
	@Transactional
	public CollegeDTO add(CollegeDTO dto) {
		return dao.add(dto);
	}

	/**
	 * Updates College
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(CollegeDTO dto) {
		dao.update(dto);
	}

	/**
	 * Deletes a College
	 */

	@Transactional
	public CollegeDTO delete(long id) {
		return dao.delete(id);
	}

	/**
	 * Search a College. It applies pagination.
	 */
	@Transactional(readOnly = true)
	public List<CollegeDTO> search(CollegeDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	/**
	 * Finds a College by its ID
	 */
	@Transactional(readOnly = true)
	public CollegeDTO get(long id) {
		return dao.findByPK(id);
	}

	@Transactional(readOnly = true)
	public CollegeDTO get(String name) {
		return dao.findByName(name);
	}

}
