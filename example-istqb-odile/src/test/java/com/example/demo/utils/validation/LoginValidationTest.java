package com.example.demo.utils.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.AgeStatus;

class LoginValidationTest {
	
	@Test
	void testAgeValidation() {
		
		String recvMsg = LoginValidation.ageValidation(8);
		
		String expMsg = AgeStatus.MINEUR.toString();
		
		assertEquals(recvMsg,expMsg);
	}

}
