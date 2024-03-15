package com.techm.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.dto.EducationalDetailsDTO;
import com.techm.dto.JobApplicationDTO;
import com.techm.dto.JobDTO;
import com.techm.entity.Applicant;
import com.techm.entity.Document;
import com.techm.entity.EducationalDetails;
import com.techm.entity.Job;
import com.techm.entity.JobApplication;
import com.techm.entity.PersonalDetails;
import com.techm.repository.ApplicantRepository;
import com.techm.repository.DocumentRepository;
import com.techm.repository.EducationalDetailsRepository;
import com.techm.repository.JobApplicationRepository;
import com.techm.repository.JobRepository;
import com.techm.repository.PersonalDetailsRepository;
import com.techm.service.ApplicantService;

import jakarta.transaction.Transactional;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private EducationalDetailsRepository educationalDetailsRepository;

	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Autowired
	private JobRepository jobRepository;

	@Override
	public void registerApplicant(Applicant applicant) {
		applicantRepository.save(applicant);
	}

	@Override
	public Applicant loginApplicant(String username, String password) {
		Applicant applicant = applicantRepository.findByUsername(username);

		if (applicant != null && isValidPassword(password, applicant.getPassword())) {
			return applicant;
		} else {
			return null;
		}
	}

	private boolean isValidPassword(String inputPassword, String storedPassword) {

		return inputPassword.equals(storedPassword);
	}

	@Override
	public void addEducationDetails(Long applicantId, EducationalDetailsDTO educationalDetailsDTO) {
		Applicant applicant = applicantRepository.findById(applicantId)
				.orElseThrow(() -> new RuntimeException("Applicant not found"));

		EducationalDetails educationalDetails = new EducationalDetails();
		BeanUtils.copyProperties(educationalDetailsDTO, educationalDetails);
		educationalDetails.setApplicant(applicant);
		educationalDetailsRepository.save(educationalDetails);
	}

	@Override
	public void personalDetails(Long applicantId, PersonalDetails personalDetails) {
		// TODO Auto-generated method stub
		Applicant applicant = applicantRepository.findById(applicantId)
				.orElseThrow(() -> new RuntimeException("Applicant not found"));

		personalDetails.setApplicant(applicant);
		personalDetailsRepository.save(personalDetails);

	}

	@Override
	@Transactional
	public void addDegreeDocument(Long applicantId, Document document) {
		// TODO Auto-generated method stub

		Applicant applicant = applicantRepository.findById(applicantId)
				.orElseThrow(() -> new RuntimeException("Applicant not found"));
		document.setApplicant(applicant);
		documentRepository.save(document);
	}

	@Override
	public List<JobApplicationDTO> getAppliedJobs(Long applicantId) {
		List<JobApplication> jobApplications = jobApplicationRepository.findByApplicantId(applicantId);
		return jobApplications.stream().map(this::convertToJobApplicationDTO).collect(Collectors.toList());
	}

	private JobApplicationDTO convertToJobApplicationDTO(JobApplication jobApplication) {
		JobApplicationDTO dto = new JobApplicationDTO();
		System.out.println(jobApplication.getJob().getId());
		BeanUtils.copyProperties(jobApplication, dto);
		dto.setApplicantId(jobApplication.getApplicant().getId());
		dto.setJobId(jobApplication.getJob().getId());
		dto.setJobTitle(jobApplication.getJob().getJobTitle());
		return dto;
	}

	public List<JobDTO> searchJobsByQualification(String qualification) {
		List<Job> jobs = jobRepository.findByQualification(qualification);
		return jobs.stream().map(this::convertToJobDTO).collect(Collectors.toList());
	}

	private JobDTO convertToJobDTO(Job job) {
		JobDTO jobDTO = new JobDTO();

		jobDTO.setJobTitle(job.getJobTitle());
		jobDTO.setQualificationRequired(job.getQualificationRequired());
		jobDTO.setVacancyCount(job.getVacancyCount());
		jobDTO.setApplicationStatus(job.getApplicationStatus());
		jobDTO.setLastDate(job.getLastDate());

		return jobDTO;
	}

	@Override
	public List<JobDTO> filterJobsByCriteria(String criteria) {
		// Implement filter logic
		return null;
	}

	@Override
	public void applyForJob(Long applicantId, Long jobId) {
		Applicant applicant = applicantRepository.findById(applicantId)
				.orElseThrow(() -> new RuntimeException("Applicant not found"));

		Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));

		JobApplication jobApplication = new JobApplication();
		jobApplication.setApplicant(applicant);
		jobApplication.setJob(job);
		jobApplication.setApplicationStatus("Applied");
		jobApplicationRepository.save(jobApplication);
	}

	
	public Applicant getApplicantById(Long id) {
		return applicantRepository.findById(id).get();

	}

}
