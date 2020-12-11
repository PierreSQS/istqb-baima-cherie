package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;
import com.example.demo.utils.validation.LoginValidation;

@ExtendWith(MockitoExtension.class)
class MessageServiceIntegrationTest {
	
	private LoginValidation fValidation;
	
	@Mock
	private LoginRepository fLoginRepo;
	
	
	private MessageService fMsgServ;	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fValidation = new LoginValidation();
		fMsgServ = new MessageService(fValidation, fLoginRepo);	
	}

	@AfterEach
	void tearDown() throws Exception {
	}	

	@Test
	void testMessageForJuniors() {
		LoginData login = new LoginData(10);
		Message msg = fMsgServ.getMessage(login);
		assertEquals("XY", msg.getMessage());
	}

	@Test
	void testMessageForAdults() {
		LoginData login = new LoginData(30);
		Message msg = fMsgServ.getMessage(login);
		assertEquals("AB", msg.getMessage());
	}

}
