package com.sunilos.ctl;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunilos.dto.CollegeDTO;
import com.sunilos.dto.MarksheetDTO;
import com.sunilos.exception.ApplicationException;
import com.sunilos.exception.DuplicateRecordException;
import com.sunilos.form.MarksheetForm;
import com.sunilos.service.MarksheetServiceInt;

/**
 * Controller contains Marksheet navigation logic.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Controller
@RequestMapping(value = "/Marksheet")
public class MarksheetCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(MarksheetCtl.class);

	@Autowired
	MarksheetServiceInt service;

	@RequestMapping(method = RequestMethod.GET)
	public String display(@ModelAttribute("marksheetForm") MarksheetForm form,
			Model model) {

		long id = form.getId();

		if (id > 0) {
			MarksheetDTO dto = service.get(id);
			form.populateForm(dto);
		}

		return "page.markhseet";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(
			@ModelAttribute("marksheetForm") @Valid MarksheetForm form,
			BindingResult bindingResult, Model model) throws Exception {

		String op = form.getOperation();

		if (bindingResult.hasErrors() && !OP_CANCEL.equals(op)
				&& !OP_DELETE.equals(op)) {
			return "page.markhseet";
		}

		MarksheetDTO dto = (MarksheetDTO) form.getDTO(new MarksheetDTO());

		if (OP_SAVE.equals(op)) {
			try {
				if (form.getId() > 0) {
					service.update(dto);
					model.addAttribute("message",
							"Marksheet is successfully updated");
				} else {
					long id = service.add(dto);
					form.setId(id);
					model.addAttribute("message",
							"Marksheet is successfully added");
				}
			} catch (ApplicationException e) {
				log.error(e);
				model.addAttribute("error", e.getMessage());
			} catch (DuplicateRecordException e) {
				log.error(e);
				model.addAttribute("error", "Marksheet is already exists.");
			}
		} else if (OP_DELETE.equals(op)) {
			try {
				service.delete(form.getId());
				model.addAttribute("message",
						"Marksheet is successfully deleted");
			} catch (ApplicationException e) {
				log.error(e);
				model.addAttribute("error", e.getMessage());
			}
		} else if (OP_CANCEL.equals(op)) {
			return "redirect:Marksheet/search";
		}

		return "page.markhseet";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String displaySearch(
			@ModelAttribute("marksheetForm") MarksheetForm form, Model model) {

		MarksheetDTO dto = (MarksheetDTO) form.getDTO(new MarksheetDTO());

		try {
			List<CollegeDTO> list = list = service.search(dto,
					form.getPageNo(), form.getPageSize());
			model.addAttribute("list", list);
		} catch (Exception e) {
			model.addAttribute("error", "system error" + e.getMessage());
		}

		return "page.marksheetList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String submitSearch(
			@ModelAttribute("marksheetForm") MarksheetForm form, Model model) {

		MarksheetDTO dto = (MarksheetDTO) form.getDTO(new MarksheetDTO());

		List<MarksheetDTO> list = null;

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		String op = form.getOperation();

		System.out.println("operation " + op);

		System.out.println("Page No" + form.getPageNo());
		System.out.println("Page Size" + form.getPageSize());

		long[] ids = form.getIds();

		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op)
					|| "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op)) {
					pageNo--;
				}
			} else if (OP_NEW.equalsIgnoreCase(op)) {
				return "redirect:/Marksheet";
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

			list = service.search(dto, pageNo, pageSize);

			System.out.println("List Size " + list.size());
			model.addAttribute("list", list);

		} catch (Exception e) {
			model.addAttribute("error", "system error" + e.getMessage());
		}

		return "page.marksheetList";
	}

}
