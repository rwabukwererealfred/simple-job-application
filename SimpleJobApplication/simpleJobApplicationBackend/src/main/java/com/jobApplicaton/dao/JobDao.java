package com.jobApplicaton.dao;

import java.util.List;

import com.jobApplicaton.model.Job;

public interface JobDao {

	public List<Job>jobList();
	public Job jobDetails(int jobId);
}
