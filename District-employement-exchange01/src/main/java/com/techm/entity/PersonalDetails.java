package com.techm.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal_details")
public class PersonalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String address;
	private LocalDate dateOfBirth;
	private String gender;

	@OneToOne
    @JoinColumn(name = "applicant_id")  // This is the owning side of the relationship
    private Applicant applicant;
	

	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonalDetails(Long id, String address, LocalDate dateOfBirth, String gender, Applicant applicant) {
		super();
		this.id = id;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "PersonalDetails [id=" + id + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", applicant=" + applicant + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	}
