package com.webapp.datamodel;

import javax.validation.constraints.Pattern;


public class SignInModel2 {

	@Pattern(regexp ="^[a-zA-Z0-9-_]*$")
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}