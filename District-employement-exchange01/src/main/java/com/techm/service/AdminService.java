package com.techm.service;

import java.util.List;

import com.techm.dto.JobDTO;
import com.techm.entity.Admin;
import com.techm.entity.Job;
import com.techm.entity.JobApplication;

public interface AdminService {

    List<JobApplication> getApplicantsForJob(Long jobId);

    int getNumberOfApplicants(Long jobId);

	void addJob(JobDTO jobDTO);

	void removeJob(Long jobId);
	
	Admin adminLongin(String username,String password);

	List<Job> getAllJobs();
}


