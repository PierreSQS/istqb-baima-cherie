package com.example.demo.configuration;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.persistence.LoginRepository;
import com.example.demo.services.MessageService;

@Configuration 
public class TestConfig {
	
	@MockBean
	private LoginRepository loginRepo;
	
	@Bean
	public MessageService createMessageService() {
		return new MessageService(loginRepo);
	}

}
