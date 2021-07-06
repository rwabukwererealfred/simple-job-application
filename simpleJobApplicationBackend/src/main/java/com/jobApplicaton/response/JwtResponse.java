package com.jobApplicaton.response;

import java.util.List;

import com.jobApplicaton.model.User;


public class JwtResponse {

	private int id;
	private String username;
	private String password;
	private boolean active;
	private User user;
	private List<String>role;
	private String token;
	
	


	public JwtResponse(int id, String username, String password, boolean active, User user, List<String> role,
			String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
		this.user = user;
		this.role = role;
		this.token = token;
	}


	public JwtResponse() {
		
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	


	public List<String> getRole() {
		return role;
	}


	public void setRole(List<String> role) {
		this.role = role;
	}


	

	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	
	
	
}
