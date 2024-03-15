package com.techm.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String documentName;

	@Lob
	@Column(nullable = false, columnDefinition = "LONGBLOB")
	private byte[] documentContent;

	@ManyToOne
	@JoinColumn(name = "applicant_id")
	private Applicant applicant;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(Long id, String documentName, byte[] documentContent, Applicant applicant) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.documentContent = documentContent;
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", documentName=" + documentName + ", documentContent="
				+ Arrays.toString(documentContent) + ", applicant=" + applicant + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

}
