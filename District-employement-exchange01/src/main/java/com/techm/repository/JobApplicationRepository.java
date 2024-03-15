package com.techm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // Custom queries if needed
	
	 List<JobApplication> findByApplicantId(Long applicantId);

	int countByJobId(Long jobId);

	List<JobApplication> findByJobId(Long jobId);
}
