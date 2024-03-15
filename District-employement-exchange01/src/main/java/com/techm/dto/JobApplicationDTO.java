package com.techm.dto;

public class JobApplicationDTO {

	private Long id;
	private Long applicantId;
	private Long jobId;
	private String jobTitle;
	private String applicationStatus;

	// Add other relevant fields
	public JobApplicationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobApplicationDTO(Long id, Long applicantId, Long jobId, String jobTitle, String applicationStatus) {
		super();
		this.id = id;
		this.applicantId = applicantId;
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.applicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "JobApplicationDTO [id=" + id + ", applicantId=" + applicantId + ", jobId=" + jobId + ", jobTitle="
				+ jobTitle + ", applicationStatus=" + applicationStatus + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

}
