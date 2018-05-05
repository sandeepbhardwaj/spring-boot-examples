package com.koko.springboot.data;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	InitializingBean seedDatabase(CarRepository repository) {
		return () -> {
			repository.save(new Car("Honda", "Civic", 1997));
			repository.save(new Car("Honda", "City", 2000));
			repository.save(new Car("Ford", "Escort", 1985));
		};
	}

	@Bean
	CommandLineRunner exampleQuery(CarRepository repository) {
		return args -> repository.findByMakeIgnoringCase("HONDA").forEach(System.err::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
