package com.techm.dto;

public class EducationalDetailsDTO {

	private String qualification;
	private String institute;
	private Integer passingYear;

	public EducationalDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EducationalDetailsDTO(String qualification, String institute, Integer passingYear) {
		super();
		this.qualification = qualification;
		this.institute = institute;
		this.passingYear = passingYear;
	}

	@Override
	public String toString() {
		return "EducationalDetailsDTO [qualification=" + qualification + ", institute=" + institute + ", passingYear="
				+ passingYear + "]";
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

}
