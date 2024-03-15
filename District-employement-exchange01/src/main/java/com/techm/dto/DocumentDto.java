package com.techm.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {

	private String documentName;
	private MultipartFile documentContent;

	public DocumentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentDto(String documentName, MultipartFile documentContent) {
		super();
		this.documentName = documentName;
		this.documentContent = documentContent;
	}

	@Override
	public String toString() {
		return "DocumentDto [documentName=" + documentName + ", documentContent=" + documentContent + "]";
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public MultipartFile getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(MultipartFile documentContent) {
		this.documentContent = documentContent;
	}

}
