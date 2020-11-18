package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.LoginData;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLoginForm(LoginData plogin) {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String submitLoginForm(@Valid LoginData pLogin, Errors error) {
		if (error.hasErrors()) {
			return "loginForm";
		}

		//Controller Variant1 b. Works but stays on @/login
		// Not optimal in the reality. Normally a Redirect should occurs!!
		return "loginSuccess";
	}

}
