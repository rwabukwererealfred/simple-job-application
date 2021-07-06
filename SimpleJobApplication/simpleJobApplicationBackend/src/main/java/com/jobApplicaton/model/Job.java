package com.jobApplicaton.model;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;



public class Job {

	private int id;
	private String jobTilte;
	private String description;
	private Date publishedDate;
	private Date deadline;
	private String experience;
	
	@Enumerated(EnumType.STRING)
	private JobStatus status;
	
	
	public static enum JobStatus{
		Open, Closed
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTilte() {
		return jobTilte;
	}
	public void setJobTilte(String jobTilte) {
		this.jobTilte = jobTilte;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public JobStatus getStatus() {
		return status;
	}
	public void setStatus(JobStatus status) {
		this.status = status;
	}
	
	public Job(int id, String jobTilte, Date publishedDate, Date deadline, String experience,
			JobStatus status) {
		super();
		this.id = id;
		this.jobTilte = jobTilte;
		this.publishedDate = publishedDate;
		this.deadline = deadline;
		this.experience = experience;
		this.status = status;
	}
	public Job() {
		
	}
	
	
}
