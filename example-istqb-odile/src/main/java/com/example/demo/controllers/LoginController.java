package com.example.demo.controllers;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController implements WebMvcConfigurer{
	
	@Autowired
	private LoginRepository loginRepo;
	
	// for any redirection a Handler should be implemented
	// this is a way to do it without a Handler-Method
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/loginOk").setViewName("loginSuccess");
	}

	@GetMapping("/login")
	public String showLoginForm(LoginData plogin) {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String submitLoginForm(@Valid LoginData pLogin, Errors error) {
		if (error.hasErrors()) {
			return "loginForm";
		}
		
		LocalDateTime today = LocalDateTime.now();
		pLogin.setLoggedAt(today);
		loginRepo.save(pLogin);
		log.info("redirecting to /loginSuccess");
		
		return "redirect:/loginOk";
	}

}

