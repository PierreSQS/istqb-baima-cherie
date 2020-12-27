package com.example.demo.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Message;
import com.example.demo.entities.LoginData;
import com.example.demo.persistence.LoginRepository;
import com.example.demo.utils.validation.LoginValidation;

@Service
public class MessageService {

	private LoginRepository loginRepo;
	
	public MessageService(LoginRepository loginRepo) {
		super();
		this.loginRepo = loginRepo;
	}

	public Message processLoginData(LoginData pLoginData) {
		String ageStatus = LoginValidation.ageValidation(pLoginData.getAge());
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
		
		returnedMsg = new Message(msgIndex, pLoginData.getPrenom());		
		returnedMsg.setAgeStatus(ageStatus);
		LocalDateTime today = LocalDateTime.now();
		pLoginData.setLoggedAt(today);
		
		String loginDate = today.toLocalDate().toString();
		String loginTime = today.toLocalTime().toString();
		
		loginRepo.save(pLoginData);
		
		returnedMsg.setLoginDate(loginDate);
		returnedMsg.setLoginTime(loginTime);
		return returnedMsg;
	
	}
}
