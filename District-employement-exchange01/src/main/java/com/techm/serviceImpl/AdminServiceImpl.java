package com.techm.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.dto.ApplicantDTO;
import com.techm.dto.JobDTO;
import com.techm.entity.Admin;
import com.techm.entity.Applicant;
import com.techm.entity.Job;
import com.techm.entity.JobApplication;
import com.techm.repository.AdminRepository;
import com.techm.repository.ApplicantRepository;
import com.techm.repository.JobApplicationRepository;
import com.techm.repository.JobRepository;
import com.techm.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<JobApplication> getApplicantsForJob(Long jobId) {
        List<JobApplication> jobApplications = jobApplicationRepository.findByJobId(jobId);
        return jobApplications;
    }

    @Override
    public void addJob(JobDTO jobDTO) {
        Job job = new Job();
        BeanUtils.copyProperties(jobDTO, job);
        jobRepository.save(job);
    }

    @Override
    public void removeJob(Long jobId) {
        jobRepository.closeJobById(jobId);
    }

    @Override
    public int getNumberOfApplicants(Long jobId) {
        return jobApplicationRepository.countByJobId(jobId);
    }

	@Override
	public Admin adminLongin(String username, String password) {
		Admin admin = adminRepository.findByUsername(username);

		if (admin != null && isValidPassword(password, admin.getPassword())) {
			return admin;
		} else {
			return null;
		}
	}
	
	private boolean isValidPassword(String inputPassword, String storedPassword) {

		return inputPassword.equals(storedPassword);
	}

	@Override
	public List<Job> getAllJobs() {
		
		List<Job> jobList = jobRepository.findAll()
		        .stream()
		        .filter(job -> "opened".equalsIgnoreCase(job.getApplicationStatus()))
		        .collect(Collectors.toList());

		return jobList;
	}

}

