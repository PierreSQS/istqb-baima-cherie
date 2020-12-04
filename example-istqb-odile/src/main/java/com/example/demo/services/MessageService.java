package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;
import com.example.demo.utils.validation.LoginValidation;

@Service
public class MessageService {

	private LoginValidation validation;

	private LoginRepository loginRepo;

	public MessageService(LoginValidation validation, LoginRepository loginRepo) {
		super();
		this.validation = validation;
		this.loginRepo = loginRepo;
	}

	public Message getMessage(LoginData pLoginData) {
		String ageStatus = validation.ageValidation(pLoginData.getAge());
		switch (ageStatus) {
		case "MINEUR" :
			return new Message(1, "XY");			

		case "ADULTE" :
			return new Message(2, "AB");			

		case "SENIOR" :
			return new Message(3, "CD");			

		default:
			return new Message(4, "FG");
		}
	
	}
}
