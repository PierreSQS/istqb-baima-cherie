package com.example.demo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginDataTest {
	
	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();;
    private static final Validator validator = factory.getValidator();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void fieldsNomAndPrenomsShouldHaveCharactersBetween5And8() {
		LoginData vLoginData = new LoginData();
		vLoginData.setPrenom("B"); // Constraint Violation
		vLoginData.setNom("Baim"); // Constraint Violation
		
		Set<ConstraintViolation<LoginData>> violations = validator.validate(vLoginData);
		
		assertEquals(2, violations.size());		
		
		violations.forEach(violation -> System.out.println(violation.getMessage()));
	}

	@Test
	void ageMustBeGEZero() {
		LoginData vLoginData = new LoginData();
		vLoginData.setAge(-1); // Constraint Violation
		
		Set<ConstraintViolation<LoginData>> violations = validator.validate(vLoginData);
		
		assertEquals(1, violations.size());
		
		violations.forEach(violation -> System.out.println(violation.getMessage()));

	}

}
