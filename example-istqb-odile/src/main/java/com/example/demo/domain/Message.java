package com.example.demo.domain;

import lombok.Data;

@Data
public class Message {

	private Integer Id;
	private String message;

	public Message(Integer id, String message) {
		super();
		Id = id;
		this.message = message;
	}

}
