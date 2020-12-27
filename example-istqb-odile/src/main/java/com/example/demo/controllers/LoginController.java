package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.services.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("message")
public class LoginController {
	
	private MessageService msgServ;
	
	public LoginController(MessageService msgServ) {
		super();
		this.msgServ = msgServ;
	}
	
	@ModelAttribute("message")
	public Message message() {
		return new Message();
	}

	// Since we want to get the processed Message, we have to
	// implement the logic and replace the ViewController
	@GetMapping("loginOk")
	public String showLoginSuccess(@ModelAttribute Message message, Model model, SessionStatus status) {
		
		log.info("processed Message: {}", message);
		model.addAttribute("message", message);
		status.setComplete();
		return "loginSuccess";
	}
	
	
	@GetMapping("/login")
	public String showLoginForm(LoginData plogin) {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String submitLoginForm(@Valid LoginData pLogin, Errors error, Model model, @ModelAttribute Message msg) {
		if (error.hasErrors()) {
			return "loginForm";
		}
		
		msg = msgServ.processLoginData(pLogin);

		log.info("the received msg: {}", msg);
		log.info("redirecting to /loginOk");
		
		model.addAttribute("message", msg);
		return "redirect:/loginOk";
	}

}

