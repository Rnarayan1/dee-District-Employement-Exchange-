package com.techm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "educational_details")
public class EducationalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String qualification;
	private String institute;
	private Integer passingYear;

	@ManyToOne
    @JoinColumn(name = "applicant_id")
	private Applicant applicant;

	public EducationalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EducationalDetails(Long id, String qualification, String institute, Integer passingYear,
			Applicant applicant) {
		super();
		this.id = id;
		this.qualification = qualification;
		this.institute = institute;
		this.passingYear = passingYear;
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "EducationalDetails [id=" + id + ", qualification=" + qualification + ", institute=" + institute
				+ ", passingYear=" + passingYear + ", applicant=" + applicant + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public Integer getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Integer passingYear) {
		this.passingYear = passingYear;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

}
