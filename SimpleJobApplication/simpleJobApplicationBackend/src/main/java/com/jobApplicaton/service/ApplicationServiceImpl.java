package com.jobApplicaton.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobApplicaton.dao.JobApplicationDao;
import com.jobApplicaton.dao.JobDao;
import com.jobApplicaton.dao.UserDao;
import com.jobApplicaton.model.Job;
import com.jobApplicaton.model.JobApplication;
import com.jobApplicaton.model.JobApplication.Status;
import com.jobApplicaton.model.User;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JobApplicationDao jobApplicationDao;

	@Override
	public List<Job> jobList() {
		
		return jobDao.jobList();
	}

	@Override
	public Job jobDetails(int id) {
		return jobDao.jobDetails(id);
	}

	@Override
	public String applyForJob(User user, int jobId, String cvFile) {
		try {
	JobApplication application =new JobApplication();
		Optional<User>us = userDao.findAll().stream().filter(i->i.getEmail().equals(user.getEmail())).findAny();
		if(us.isPresent()) {
		
			Optional<JobApplication>job = jobApplicationDao.findAll().stream().filter(i->i.getUser().getId() == us.get().getId() &&
					i.getJobId() == jobId).findAny();
			if(!job.isPresent()) {
				System.out.println("account is arleady exist");
			Job j = jobDao.jobDetails(jobId);
			application.setAppliedDate(new Date());
			application.setUser(us.get());
			application.setJobId(jobId);
			application.setCvFile(cvFile);
			application.setJobTitle(j.getJobTilte());
			application.setStatus(Status.Pending);
			jobApplicationDao.save(application);
			return "success";
			}else {
				return "You have arleady applied to this position";
			}
		}else {
			Job j = jobDao.jobDetails(jobId);
			System.out.println("account is not exist");
			user.setStatus(com.jobApplicaton.model.User.Status.Applicant);
			user.setCv(cvFile);
			user.setActive(true);
			userDao.save(user);
			application.setAppliedDate(new Date());
			application.setCvFile(cvFile);
			application.setJobTitle(j.getJobTilte());
			application.setUser(user);
			application.setJobId(jobId);
			application.setStatus(Status.Pending);
			jobApplicationDao.save(application);
			return "success";
			
		}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}

	@Override
	public String createAccount(User user) {
		Optional<User>us = userDao.findAll().stream().filter(i->i.getEmail().equals(user.getEmail())).findAny();
		if(us.isPresent()) {
			
			us.get().setPassword(user.getPassword());
			userDao.save(us.get());
		}else {
			userDao.save(user);
		}
		return "success";
	}

	@Override
	public List<JobApplication> jobApplicationList() {
		return jobApplicationDao.findAll().stream().sorted((x,y)->x.getUser().getFirstName().compareTo(y.getUser().getFirstName())).
				collect(Collectors.toList());
	}

	@Override
	public JobApplication applicantDetails(int id) {
			
		return jobApplicationDao.getOne(id);
	}

	@Override
	public void passedMethod(int jobApplicationId) {
		JobApplication j =  jobApplicationDao.getOne(jobApplicationId);
		j.setStatus(Status.Passed);
		jobApplicationDao.save(j);
		
	}

	@Override
	public void droppedMethod(int jobApplictionId, String comment) {
		JobApplication j =  jobApplicationDao.getOne(jobApplictionId);
		j.setComment(comment);
		j.setStatus(Status.Dropped);
		jobApplicationDao.save(j);
		
	}

	@Override
	public Optional<User> email(String email) {
		
		return userDao.findByEmail(email);
	}

}
