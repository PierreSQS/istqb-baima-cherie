package com.example.demo.configuration;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.persistence.LoginRepository;
import com.example.demo.services.MessageService;
import com.example.demo.utils.validation.LoginValidation;

@Configuration 
public class TestConfig {
	
	@MockBean
	private LoginRepository loginRepo;
	
	@Bean
	public LoginValidation createLoginValidation() {
		return new LoginValidation();
	}

	@Bean
	public MessageService createMessageService() {
		return new MessageService(createLoginValidation(), loginRepo);
	}

}
