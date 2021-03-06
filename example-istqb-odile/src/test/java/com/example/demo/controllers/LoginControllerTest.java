package com.example.demo.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.services.MessageService;

@WebMvcTest(controllers = {LoginController.class})
class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	MessageService msgServ;

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
	void testShowLoginForm() throws Exception {
		mockMvc.perform(get("/login"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("loginData"))
			.andExpect(view().name("loginForm"));
//			.andDo(print());
	}
	
	// The test is working because there is no @Not empty
	// validation on the fields
	@Test
	void testSubmitLoginFormWithoutParamsMissingPASS() throws Exception {
		mockMvc.perform(post("/login"))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().hasNoErrors())
			.andExpect(view().name("redirect:/loginOk"));
//			.andDo(print());
		}

	@Test
	void testSubmitLoginFormWithParamsCorrectPASS() throws Exception {
		mockMvc.perform(post("/login")
				.param("prenom", "Odile")
				.param("nom", "Baima")
				.param("age", "10"))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().hasNoErrors())
			.andExpect(view().name("redirect:/loginOk"));
//			.andDo(print());
	}
	
	@Test
	void testSubmitLoginFormWithParamsWrongFAIL() throws Exception {
		mockMvc.perform(post("/login")
				.param("prenom", "Odil")
				.param("nom", "Baim")
				.param("age", "-1"))
			.andExpect(status().isOk())
			.andExpect(model().hasErrors())
			.andExpect(model().attributeHasFieldErrors("loginData", "nom"))
			.andExpect(model().attributeHasFieldErrors("loginData", "prenom"))
			.andExpect(model().attributeHasFieldErrors("loginData", "age"))
			.andExpect(view().name("loginForm"));
//			.andDo(print());
	}
	
	@Test
	void testShowHomeOrIndexPage() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Login Page")))
			.andExpect(view().name("index"));
//			.andDo(print());
	}

}
