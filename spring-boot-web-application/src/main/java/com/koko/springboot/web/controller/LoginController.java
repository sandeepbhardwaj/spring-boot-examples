package com.koko.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String showLoginPage(ModelMap model) {
		model.put("name", "in28Minutes");
		return "welcome";
	}

	//	@RequestMapping(value = "/login", method = RequestMethod.POST)
	//	private String showWelcomePage(@RequestParam String name, ModelMap model) {
	//		model.put("name", name);
	//		return "welcome";
	//	}
}
