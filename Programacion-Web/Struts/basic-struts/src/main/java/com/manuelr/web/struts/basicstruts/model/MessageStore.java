package com.manuelr.web.struts.basicstruts.model;

public class MessageStore {
	private String message;

	public MessageStore() {
		// TODO Auto-generated constructor stub
		message = "Hello world of struts";
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return message + " (from toString)";
	}
}
