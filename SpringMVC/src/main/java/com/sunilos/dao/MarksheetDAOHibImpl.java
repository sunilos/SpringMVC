package com.sunilos.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunilos.dto.MarksheetDTO;

/**
 * Hibernate implementation of Marskheet DAO.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository
public class MarksheetDAOHibImpl implements MarksheetDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger log = Logger.getLogger(MarksheetDAOHibImpl.class);

	/**
	 * Adds a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public long add(MarksheetDTO dto) {
		log.debug("DAO add Started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */

	public void update(MarksheetDTO dto) {
		log.debug("DAO update Started");
		sessionFactory.getCurrentSession().update(dto);
		log.debug("DAO update End");
	}

	/**
	 * Deletes a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */

	public MarksheetDTO delete(long id) {
		log.debug("DAO delete Started");
		MarksheetDTO dto = findByPK(id);
		if (dto != null) {
			sessionFactory.getCurrentSession().delete(dto);
		}
		return dto;
	}

	/**
	 * Finds Marksheet by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */

	public MarksheetDTO findByPK(long pk) {
		MarksheetDTO dto = sessionFactory.getCurrentSession().get(MarksheetDTO.class, pk);
		return dto;
	}

	/**
	 * Finds Marksheet by RollNo
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */

	public MarksheetDTO findByRollNo(String rollNo) {
		MarksheetDTO dto = new MarksheetDTO();
		dto.setRollNo(rollNo);
		List list = search(dto);
		if (list.size() == 1) {
			dto = (MarksheetDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Searches Marksheet with pagination
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */

	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		log.debug("DAO search Started");

		Criteria c = sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class);

		if (dto.getId() > 0) {
			c.add(Restrictions.eq("id", dto.getId()));
		}
		if (dto.getName() != null && dto.getName().length() > 0) {
			c.add(Restrictions.like("name", dto.getName() + "%"));
		}
		if (dto.getRollNo() != null && dto.getRollNo().length() > 0) {
			c.add(Restrictions.like("rollNo", dto.getRollNo() + "%"));
		}
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			c.setFirstResult((pageNo - 1) * pageSize);
			c.setMaxResults(pageSize);
		}
		List list = c.list();
		log.debug("Session Factory in search :" + sessionFactory);

		log.debug("DAO search End");
		return list;
	}

	/**
	 * Searches Marksheet
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */

	public List search(MarksheetDTO dto) {
		return search(dto, 0, 0);
	}

}
