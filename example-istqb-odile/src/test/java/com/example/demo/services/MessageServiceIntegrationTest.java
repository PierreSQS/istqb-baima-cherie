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

@ExtendWith(MockitoExtension.class)
class MessageServiceIntegrationTest {
	
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
		fMsgServ = new MessageService(fLoginRepo);	
	}

	@AfterEach
	void tearDown() throws Exception {
	}	

	@Test
	void testMessageForJuniors() {
		LoginData login = new LoginData(10);
		Message msg = fMsgServ.processLoginData(login);
		assertEquals("MINEUR", msg.getAgeStatus());
	}

	@Test
	void testMessageForAdults() {
		LoginData login = new LoginData(30);
		Message msg = fMsgServ.processLoginData(login);
		assertEquals("ADULTE", msg.getAgeStatus());
	}

}
