package com.example.demo.utils.validation;

import static com.example.demo.domain.AgeStatus.ADULTE;
import static com.example.demo.domain.AgeStatus.MINEUR;
import static com.example.demo.domain.AgeStatus.SENIOR;

public class LoginValidation {
	
	public String ageValidation(int age) {
		
		if (age < 18) {
			//return "Désolé votre âge ne vous permet pas d'acceder à ce site";
			return MINEUR.toString();
		}
		
		if(age >=18 & age <= 40) {
			//return String.format("Salut %s , vous avez été enregistré à %s", nom, date.toString());
			return ADULTE.toString();
		}
		
		if(age > 40) {
//			return String.format("Salut %s , vous êtes senior et avez été enregistré à %s", nom, date.toString());
			return SENIOR.toString();
		}		
		
		return "Désolé les martiens n'ont pas le droit de se connecter";
	}

}
