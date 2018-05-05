package com.koko.springboot.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WelcomeController {

	@Value("${configuration.message}")
	String message;
	
	@RequestMapping("/message")
	public String welcome() {
		return message;
	}
}
