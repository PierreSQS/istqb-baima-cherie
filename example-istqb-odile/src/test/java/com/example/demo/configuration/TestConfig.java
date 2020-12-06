package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.services.MessageService;
import com.example.demo.utils.validation.LoginValidation;

@Configuration 
public class TestConfig { // The Class is Not in use now!!!!
	
//	@Autowired
	private LoginValidation validation;
	
//	@Autowired
//	private LoginRepository loginRepo;

	@Bean
	public LoginValidation createLoginValidation() {
		return new LoginValidation();
	}

	@Bean
	public MessageService createMessageService() {
		return new MessageService(validation);
	}

}
