package com.sunilos.ctl;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/ResponseBody")
public class ResponseBodyCtl {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String text() {
		return "<H1>This is HTML text</H1>";
	}

	@RequestMapping(value = "/plain", method = RequestMethod.GET)
	@ResponseBody
	public String plainText() {
		return "This is plain text";
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	@ResponseBody
	public String jsonText() throws IOException {
		return " {'name' : 'Ram', 'age':19}";
	}

}
