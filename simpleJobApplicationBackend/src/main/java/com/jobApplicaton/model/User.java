package com.jobApplicaton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	@Column(name="EMAIL")
	@Email(message="please use email format")
	private String email;
	@Column(name="CV")
	private String cv;
	@Column(name="ACTIVE")
	private boolean active;
	
	@Column(name="PASSWORD")
	@Size(min=6, message="password must be atleast 6 digit")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;
	
	public static enum Status{
		HR,Applicant
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(int id, String firstName, String lastName, String phoneNumber,
			@Email(message = "please use email format") String email, String cv,
			@Size(min = 6, message = "password must be atleast 6 digit") String password, Status status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.cv = cv;
		this.password = password;
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
