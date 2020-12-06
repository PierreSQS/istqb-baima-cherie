package com.example.demo.utils.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.AgeStatus;

class LoginValidationTest {
	
	private LoginValidation validation;
	
	

	@Test
	void testAgeValidation() {
		validation = new LoginValidation();
		
		String recvMsg = validation.ageValidation(8);
		
		String expMsg = AgeStatus.MINEUR.toString();
		
		assertEquals(recvMsg,expMsg);
	}

}
