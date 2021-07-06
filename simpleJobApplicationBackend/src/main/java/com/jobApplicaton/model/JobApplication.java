package com.jobApplicaton.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="JOB_ID")
	private int jobId;
	
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Date appliedDate;
	
	private String comment;
	
	private String cvFile;
	
	
	
	public static enum Status{
		Pending, Dropped, Passed
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	



	public int getJobId() {
		return jobId;
	}



	public void setJobId(int jobId) {
		this.jobId = jobId;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Date getAppliedDate() {
		return appliedDate;
	}



	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public String getCvFile() {
		return cvFile;
	}



	public void setCvFile(String cvFile) {
		this.cvFile = cvFile;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public JobApplication(int id, int jobId, User user, Status status, Date appliedDate, String comment,
			String cvFile) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.user = user;
		this.status = status;
		this.appliedDate = appliedDate;
		this.comment = comment;
		this.cvFile = cvFile;
	}



	public JobApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
