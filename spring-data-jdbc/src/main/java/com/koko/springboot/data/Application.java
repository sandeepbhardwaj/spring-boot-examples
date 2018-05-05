package com.koko.springboot.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	CommandLineRunner exampleQuery(CarRepository repository) {
		return args -> repository.findByMakeIgnoringCase("HONDA").forEach(System.err::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
