package com.techm.service;

import java.util.List;

import com.techm.dto.EducationalDetailsDTO;
import com.techm.dto.JobApplicationDTO;
import com.techm.dto.JobDTO;
import com.techm.entity.Applicant;
import com.techm.entity.Document;
import com.techm.entity.PersonalDetails;

public interface ApplicantService {

    void registerApplicant(Applicant applicant);

    Applicant loginApplicant(String username, String password);

    void addEducationDetails(Long applicantId, EducationalDetailsDTO educationalDetailsDTO);
    
    void personalDetails(Long applicantId, PersonalDetails personalDetails);
    
    void addDegreeDocument(Long applicantId, Document document);

    List<JobApplicationDTO> getAppliedJobs(Long applicantId);

    List<JobDTO> searchJobsByQualification(String qualification);

    List<JobDTO> filterJobsByCriteria(String criteria);

    void applyForJob(Long applicantId, Long jobId);

	Applicant getApplicantById(Long id);

	
}




