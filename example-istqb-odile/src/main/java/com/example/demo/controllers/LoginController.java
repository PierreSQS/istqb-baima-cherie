package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;
import com.example.demo.services.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController implements WebMvcConfigurer{
	
	private MessageService msgServ;
	
	public LoginController(LoginRepository loginRepo, MessageService msgServ) {
		super();
		this.msgServ = msgServ;
	}

	// for any redirection a Handler should be implemented
	// this is a way to do it without a Handler-Method
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		log.info("Entering ViewController");
		registry.addViewController("/loginOk").setViewName("loginSuccess");
	}
	
	
	@GetMapping("/login")
	public String showLoginForm(LoginData plogin) {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String submitLoginForm(@Valid LoginData pLogin, Errors error, Model model) {
		if (error.hasErrors()) {
			return "loginForm";
		}
		
		Message msg = msgServ.processLoginData(pLogin);

		log.info("the received msg: {}", msg);
		log.info("redirecting to /loginOk");
		
		model.addAttribute("message", msg);
		return "redirect:/loginOk";
	}

}

