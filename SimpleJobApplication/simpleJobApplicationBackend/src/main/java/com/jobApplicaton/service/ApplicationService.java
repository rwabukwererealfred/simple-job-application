package com.jobApplicaton.service;

import java.util.List;
import java.util.Optional;

import com.jobApplicaton.model.Job;
import com.jobApplicaton.model.JobApplication;
import com.jobApplicaton.model.User;

public interface ApplicationService {

	public List<Job>jobList();
	public Job jobDetails(int id);
	
	public String applyForJob(User user, int jobId, String cvFile);
	public String createAccount(User user);
	
	public List<JobApplication>jobApplicationList();
	public JobApplication applicantDetails(int id);
	
	public void passedMethod(int jobApplicationId);
	public void droppedMethod(int jobApplictionId, String comment);
	
	Optional<User>email(String email);
	
	
}

