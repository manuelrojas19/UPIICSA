package com.manuelr.web.struts.basicstruts.action.register;

import com.manuelr.web.struts.basicstruts.model.Person;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Person personBean;
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public Person getPersonBean() {
        return personBean;
    }
    
    public void setPersonBean(Person person) {
        personBean = person;
    }
    
    public void validate() {
    	if (personBean.getFirstName().length() == 0) {
    		addFieldError("personBean.firstName", "First name is required.");
    	}
    	if (personBean.getEmail().length() == 0) {
    		addFieldError("personBean.email", "Email is required");
    	}
    	if (personBean.getAge() < 18) {
    		addFieldError("personBean.age", "Age is required and must be 18 older");
    	}
    }
}
