package com.manuelr.web.struts.basicstruts.action.helloworld;

import com.manuelr.web.struts.basicstruts.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private static int helloCount = 0;

	private MessageStore messageStore;

	public String execute() {
		messageStore = new MessageStore();
		helloCount++;
		if (userName != null)
			messageStore.setMessage(messageStore.getMessage() + " " + userName);
		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public int getHelloCount() {
		return helloCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
