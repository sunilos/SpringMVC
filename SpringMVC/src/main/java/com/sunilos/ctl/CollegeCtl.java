package com.sunilos.ctl;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunilos.dto.CollegeDTO;
import com.sunilos.form.CollegeForm;
import com.sunilos.service.CollegeServiceInt;

/**
 * College controller, contains navigation logic.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Controller
@RequestMapping(value = "/College")
public class CollegeCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(CollegeCtl.class);

	@Autowired
	CollegeServiceInt service;

	/**
	 * Contains Add/Edit College display logic
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping
	public String display(@ModelAttribute("collegeForm") CollegeForm form, Model model) {

		long id = form.getId();

		if (id > 0) {
			CollegeDTO dto = service.get(id);
			form.populateForm(dto);
		}

		return "CollegeView";
	}

	/**
	 * Contains Add/Edit/Delete College submit logic
	 * 
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public String submit(@ModelAttribute("collegeForm") @Valid CollegeForm form, BindingResult bindingResult,
			Model model) throws Exception {

		String op = form.getOperation();

		if (bindingResult.hasErrors() && !OP_CANCEL.equals(op) && !OP_DELETE.equals(op)) {
			return "CollegeView";
		}

		CollegeDTO dto = (CollegeDTO) form.getDTO(new CollegeDTO());

		try {

			if (OP_SAVE.equals(op)) {
				if (form.getId() > 0) {
					service.update(dto);
					model.addAttribute("message", "College is successfully updated");
				} else {
					dto = service.add(dto);
					form.setId(dto.getId());
					model.addAttribute("message", "College is successfully added");
				}
			} else if (OP_DELETE.equals(op)) {
				service.delete(form.getId());
				model.addAttribute("message", "College is successfully deleted");
			} else if (OP_CANCEL.equals(op)) {
				return "redirect:College/search";
			}
		} catch (DataAccessException e) {
			log.error(e);
			model.addAttribute("error", e.getMessage());
		}

		return "CollegeView";
	}

	/**
	 * Contains Search Display logic
	 * 
	 * @param form
	 * @param model
	 * @return
	 */

	// @RequestMapping(value = "/search", method = RequestMethod.GET)
	@GetMapping("/search")
	public String searchDisplay(@ModelAttribute("collegeForm") CollegeForm form, Model model) {

		CollegeDTO dto = (CollegeDTO) form.getDTO(new CollegeDTO());

		try {
			List<CollegeDTO> list = service.search(dto, form.getPageNo(), form.getPageSize());
			model.addAttribute("list", list);
		} catch (DataAccessException e) {
			model.addAttribute("error", "system error" + e.getMessage());
		}
		return "CollegeListView";
	}

	/**
	 * Contains Search Submit logic
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchSubmit(@ModelAttribute("collegeForm") CollegeForm form, Model model) {

		String op = form.getOperation();
		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();
		long[] ids = form.getIds();

		log.debug("operation " + op);
		log.debug("Page No" + form.getPageNo());
		log.debug("Page Size" + form.getPageSize());

		CollegeDTO dto = (CollegeDTO) form.getDTO(new CollegeDTO());

		List<CollegeDTO> list = null;

		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {
				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op)) {
					pageNo--;
				}
			} else if (OP_NEW.equalsIgnoreCase(op)) {
				return "redirect:/College";
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					for (long id : ids) {
						service.delete(id);
					}
				} else {
					model.addAttribute("error", "Select at least one record");
				}
			}
			pageNo = (pageNo <= 0) ? 1 : pageNo;
			form.setPageNo(pageNo);

			list = service.search(dto, pageNo, pageSize);
			model.addAttribute("list", list);

		} catch (Exception e) {
			model.addAttribute("error", "system error" + e.getMessage());
		}

		return "CollegeListView";
	}
}
