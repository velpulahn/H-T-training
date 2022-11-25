package com.hco.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
//JSON Parsing needs default constructor
	public JwtRequest() {
	}

public JwtRequest(int authorId, String username, String password, String emailId, String role) {
	super();
	this.username = username;
	this.password = password;
}


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

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "JwtRequest [username=" + username + ", password=" + password +" ]";
}

	
}