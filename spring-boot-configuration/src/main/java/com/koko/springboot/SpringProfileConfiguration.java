package com.koko.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.koko.springboot.model.ProfileConfiguration;

@Component
@Configuration
public class SpringProfileConfiguration {

	@Bean
	@Profile("dev")
	public ProfileConfiguration dev() {
		return new ProfileConfiguration("dev");
	}

	@Bean
	@Profile("cloud")
	public ProfileConfiguration cloud() {
		return new ProfileConfiguration("cloud");
	}

}
