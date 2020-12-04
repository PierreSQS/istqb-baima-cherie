package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;
import com.example.demo.utils.validation.LoginValidation;

@ExtendWith(SpringExtension.class)
class MessageServiceTest {
	
	@MockBean
	private LoginValidation fValidation;
	
	@MockBean
	private LoginRepository fLoginRepo;
	
	@Mock
	private MessageService fMsgServ;

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
	void testMessageForJuniors() {
		LoginData login = new LoginData(10);
		fail("Not yet implemented");
	}

}
