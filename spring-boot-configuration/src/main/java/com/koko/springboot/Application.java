package com.koko.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import com.koko.springboot.model.ProfileConfiguration;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	@Value("${configuration.projectName}")
	void setProjectName(String projectName) {
		System.out.println("Setting Project Name :" + projectName);
	}

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("Setting environment :" + env.getProperty("configuration.projectName"));
	}

	@Autowired
	void setConfigurationProjectProperties(ConfigurationProjectProperties cp) {
		System.out.println("ConfigurationProjectProperties.projectName  :" + cp.getProjectName());
	}
	
	@Autowired
	void setSpringProfileConfiguration(List<ProfileConfiguration> profiles) {
		System.out.println("MyProfile.profileName  :" + profiles);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
