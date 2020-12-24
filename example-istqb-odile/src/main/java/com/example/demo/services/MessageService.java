package com.example.demo.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;
import com.example.demo.utils.validation.LoginValidation;

@Service
public class MessageService {

	private LoginValidation validation;

	private LoginRepository loginRepo;
	
	public MessageService() {
		
	}
	
	// Autowired is set per Default since Spring 5.0
	// and is set for both Constructors 
	public MessageService(LoginValidation validation, LoginRepository loginRepo) {
		super();
		this.validation = validation;
		this.loginRepo = loginRepo;
	}

	// This Constructor is just there to simplify
	// the Unit-Test of this service
	public MessageService(LoginValidation validation) {
		super();
		this.validation = validation;
	}

	public Message processLoginData(LoginData pLoginData) {
		String ageStatus = validation.ageValidation(pLoginData.getAge());
		Message returnedMsg = null;
		int msgIndex = 0;
		switch (ageStatus) {
		case "MINEUR" :
			msgIndex = 1;
			break;

		case "ADULTE" :
			msgIndex = 2;
			break;

		case "SENIOR" :
			msgIndex = 3;
			break;

		default:
			msgIndex = 4;
			break;
		}
		
		returnedMsg = new Message(msgIndex, pLoginData.getNom());		
		returnedMsg.setAgeStatus(ageStatus);
		LocalDateTime today = LocalDateTime.now();
		pLoginData.setLoggedAt(today);
		
		String loginDate = today.toLocalDate().toString();
		String loginTime = today.toLocalTime().toString();
		
		loginRepo.save(pLoginData);
		
		returnedMsg.setLoginDate(loginDate);
		returnedMsg.setLoginDate(loginTime);
		return returnedMsg;
	
	}
}
