package com.techm.dto;

import java.time.LocalDate;

public class JobDTO {

	private String jobTitle;
	private String qualificationRequired;
	private Integer vacancyCount;
	private String applicationStatus;
	private LocalDate lastDate;

	public JobDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobDTO(String jobTitle, String qualificationRequired, Integer vacancyCount, String applicationStatus,
			LocalDate lastDate) {
		super();
		this.jobTitle = jobTitle;
		this.qualificationRequired = qualificationRequired;
		this.vacancyCount = vacancyCount;
		this.applicationStatus = applicationStatus;
		this.lastDate = lastDate;
	}

	@Override
	public String toString() {
		return "JobDTO [jobTitle=" + jobTitle + ", qualificationRequired=" + qualificationRequired + ", vacancyCount="
				+ vacancyCount + ", applicationStatus=" + applicationStatus + ", lastDate=" + lastDate + "]";
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getQualificationRequired() {
		return qualificationRequired;
	}

	public void setQualificationRequired(String qualificationRequired) {
		this.qualificationRequired = qualificationRequired;
	}

	public Integer getVacancyCount() {
		return vacancyCount;
	}

	public void setVacancyCount(Integer vacancyCount) {
		this.vacancyCount = vacancyCount;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public LocalDate getLastDate() {
		return lastDate;
	}

	public void setLastDate(LocalDate lastDate) {
		this.lastDate = lastDate;
	}

}
