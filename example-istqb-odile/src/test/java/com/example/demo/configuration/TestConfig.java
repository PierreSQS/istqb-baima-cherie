package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.services.MessageService;
import com.example.demo.utils.validation.LoginValidation;

@Configuration 
public class TestConfig {	
	
	@Bean
	public LoginValidation createLoginValidation() {
		return new LoginValidation();
	}

	@Bean
	public MessageService createMessageService() {
		return new MessageService(createLoginValidation());
	}

}
