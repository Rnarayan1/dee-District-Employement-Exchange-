package com.techm.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String jobTitle;
	private String qualificationRequired;
	private Integer vacancyCount;
	private String applicationStatus;
	private LocalDate lastDate;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(Long id, String jobTitle, String qualificationRequired, Integer vacancyCount, String applicationStatus,
			LocalDate lastDate) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.qualificationRequired = qualificationRequired;
		this.vacancyCount = vacancyCount;
		this.applicationStatus = applicationStatus;
		this.lastDate = lastDate;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", qualificationRequired=" + qualificationRequired
				+ ", vacancyCount=" + vacancyCount + ", applicationStatus=" + applicationStatus + ", lastDate="
				+ lastDate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
