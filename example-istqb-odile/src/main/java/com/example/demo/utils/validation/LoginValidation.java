package com.example.demo.utils.validation;

import java.time.LocalDateTime;

public class LoginValidation {
	
	public String ageValidation(String nom, int age, LocalDateTime date) {
		
		if (age < 18) {
			return "Désolé votre âge ne vous permet pas d'acceder à ce site";
		}
		
		if(age >=18 & age <= 40) {
			return String.format("Salut %s , vous avez été enregistré à %s", nom, date.toString());
		}
		
		if(age > 40) {
			return String.format("Salut %s , vous êtes senior et avez été enregistré à %s", nom, date.toString());
		}		
		
		return "Désolé les martiens n'ont pas le droit de se connecter";
	}

}
