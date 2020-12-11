package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;
import com.example.demo.utils.validation.LoginValidation;

@ExtendWith(MockitoExtension.class)
class MessageServiceUnitTest {
	
	private LoginData fLoginData;
	
	@InjectMocks
	private MessageService msgServTO;
	
	@Mock
	private LoginRepository loginRepoMock;
	
	
	@Mock
	private LoginValidation loginValidation;

	@Test
	void testShouldReturnMessageXY() {
		// Arrange
		fLoginData = new LoginData(10);
		when(loginRepoMock.save(fLoginData)).thenReturn(fLoginData);
		when(loginValidation.ageValidation(fLoginData.getAge())).thenReturn("MINEUR");
		
		// Act
		Message msg = msgServTO.getMessage(fLoginData);
		
		// Assert
		assertEquals("XY", msg.getMessage());
	}

}
