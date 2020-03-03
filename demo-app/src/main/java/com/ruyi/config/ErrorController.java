package com.ruyi.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/error")
public class ErrorController {

	@RequestMapping(value = "/")
	public ModelAndView errorPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error.html");
		return mv;
	}
}
