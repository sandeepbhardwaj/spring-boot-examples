package com.koko.springbootwebapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/login")
	@ResponseBody
	private String loginMessage() {
		return "Hello World";
	}
}
