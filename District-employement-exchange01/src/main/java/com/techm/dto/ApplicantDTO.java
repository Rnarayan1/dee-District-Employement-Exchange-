package com.techm.dto;

import java.time.LocalDate;
import java.util.Arrays;

public class ApplicantDTO {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	private String address;
	private LocalDate dateOfBirth;
	private String gender;
	
	private String qualification;
	private String institute;
	private Integer passingYear;
	
	private String documentName;
	private byte[] documentContent;

	public ApplicantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicantDTO(String username, String password, String firstName, String lastName, String email, String phone,
			String address, LocalDate dateOfBirth, String gender, String qualification, String institute,
			Integer passingYear, String documentName, byte[] documentContent) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.qualification = qualification;
		this.institute = institute;
		this.passingYear = passingYear;
		this.documentName = documentName;
		this.documentContent = documentContent;
	}

	@Override
	public String toString() {
		return "ApplicantDTO [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", qualification=" + qualification
				+ ", institute=" + institute + ", passingYear=" + passingYear + ", documentName=" + documentName
				+ ", documentContent=" + Arrays.toString(documentContent) + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public byte[] getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(byte[] documentContent) {
		this.documentContent = documentContent;
	}

}
