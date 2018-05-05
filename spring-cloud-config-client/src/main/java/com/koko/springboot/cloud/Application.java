package com.koko.springboot.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("Setting environment message :" + env.getProperty("configuration.message"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
