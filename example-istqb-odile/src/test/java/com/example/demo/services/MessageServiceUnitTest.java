package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.configuration.TestConfig;
import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
class MessageServiceUnitTest {
	
	private LoginData fLoginData;
	
	@Autowired
	private MessageService msgServTO;
	
	@Autowired
	private LoginRepository loginRepoMock;

	@Test
	void testShouldReturnMessageWithAgeMINEUR() {
		// Arrange
		fLoginData = new LoginData(10);
		
		// Act
		Message msg = msgServTO.processLoginData(fLoginData);
		
		// Assert
		verify(loginRepoMock).save(fLoginData);
		assertEquals("MINEUR", msg.getAgeStatus());
	}
	
	@Test
	void testShouldReturnMessageWithNameAndAgeSeniorAndDateToday() {
		// Arrange
		fLoginData = new LoginData(60);
		fLoginData.setNom("Mongonnam");
		fLoginData.setLoggedAt(LocalDateTime.now());
		
		// Act
		Message msg = msgServTO.processLoginData(fLoginData);
		
		// Assert
		verify(loginRepoMock).save(fLoginData);
		assertEquals("SENIOR", msg.getAgeStatus());
		assertEquals("Mongonnam", msg.getUserName());
		assertEquals(LocalDate.now().toString(), msg.getLoginDate());		
	}

}
