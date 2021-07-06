package com.jobApplicaton.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobApplicaton.model.JobApplication;

@Repository
public interface JobApplicationDao extends JpaRepository<JobApplication, Integer> {

}
