package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
	void testShouldReturnMessageXY() {
		// Arrange
		fLoginData = new LoginData(10);
		when(loginRepoMock.save(fLoginData)).thenReturn(fLoginData);
		
		// Act
		Message msg = msgServTO.getMessage(fLoginData);
		
		// Assert
		assertEquals("XY", msg.getMessage());
	}

}
