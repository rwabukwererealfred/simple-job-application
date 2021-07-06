package com.jobApplicaton.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobApplicaton.model.Job;

@Repository
public class JobDaoImpl implements JobDao {
	
	@Autowired
	private JobDataBaseMocker mock;

	@Override
	public List<Job> jobList() {
		return mock.jobList();
	}

	@Override
	public Job jobDetails(int jobId) {
		return mock.jobList().stream().filter(i->i.getId() == jobId).findAny().get();
	}

}
