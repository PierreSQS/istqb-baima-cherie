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
	
	public MessageService() {
		
	}
	
	// Autowired is set per Default since Spring 5.0
	// and is set for both Constructors 
	public MessageService(LoginValidation validation, LoginRepository loginRepo) {
		super();
		this.validation = validation;
		this.loginRepo = loginRepo;
	}

	public MessageService(LoginValidation validation) {
		super();
		this.validation = validation;
	}

	public Message getMessage(LoginData pLoginData) {
		String ageStatus = validation.ageValidation(pLoginData.getAge());
		Message returnedMsg = null;
		switch (ageStatus) {
		case "MINEUR" :
			returnedMsg = new Message(1, "XY");	
			break;

		case "ADULTE" :
			returnedMsg = new Message(2, "AB");
			break;

		case "SENIOR" :
			returnedMsg = new Message(3, "CD");
			break;

		default:
			returnedMsg = new Message(4, "FG");
			break;
		}
		
		loginRepo.save(pLoginData);
		return returnedMsg;
	
	}
}
