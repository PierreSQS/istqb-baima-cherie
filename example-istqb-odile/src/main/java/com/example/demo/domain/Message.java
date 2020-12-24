package com.example.demo.domain;

import lombok.Data;

@Data
public class Message {

	private Integer Id;
	private String userName;
	private String ageStatus;
	private String loginDate;
	private String loginTime;

	public Message() {
		super();
	}

	public Message(Integer id, String userName) {
		super();
		Id = id;
		this.userName = userName;
	}

}
