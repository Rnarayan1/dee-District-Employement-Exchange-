package com.techm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_applications")
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "applicant_id")
	private Applicant applicant;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	private String applicationStatus;

	public JobApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobApplication(Long id, Applicant applicant, Job job, String applicationStatus) {
		super();
		this.id = id;
		this.applicant = applicant;
		this.job = job;
		this.applicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "JobApplication [id=" + id + ", applicant=" + applicant + ", job=" + job + ", applicationStatus="
				+ applicationStatus + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

}
