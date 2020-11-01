package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@javax.persistence.Entity
@Table(name = "User")
public class LoginData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 5, max = 8)
	private String nom;
	
	@Column(name = "password")
	@Size(min = 4, max = 6)
	private String pwd;
	
	private LocalDateTime loggedAt;
	
	private int age;

}
