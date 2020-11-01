package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.LoginData;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String submitLoginForm(@Valid LoginData pLogin, Model pModel, Errors error) {
		if (error.hasErrors()) {
			return "LoginForm";
		}
		return "redirect:/Login";
	}

}
