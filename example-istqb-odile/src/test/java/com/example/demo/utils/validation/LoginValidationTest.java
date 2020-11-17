package com.example.demo.utils.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class LoginValidationTest {
	
	private LoginValidation validation;
	
	

	@Test
	void testAgeValidation() {
		validation = new LoginValidation();
		
		String recvMsg = validation.ageValidation("Pierrot", 8, LocalDateTime.now());
		
		String expMsg = "Désolé votre âge ne vous permet pas d'acceder à ce site";
		
		assertEquals(recvMsg,expMsg);
	}

}
