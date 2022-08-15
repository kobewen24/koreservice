package com.dialogflow.dialogflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentTemplateResponse{

	private List<String> documentId;
	private String preferredLanguageLocale;
	private int siteId;
	private List<ContentDetails> contentDetails;
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<String> getDocumentId() {
		return documentId;
	}

	public void setDocumentId(List<String> documentId) {
		this.documentId = documentId;
	}

	public String getPreferredLanguageLocale() {
		return preferredLanguageLocale;
	}

	public void setPreferredLanguageLocale(String preferredLanguageLocale) {
		this.preferredLanguageLocale = preferredLanguageLocale;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public List<ContentDetails> getContentDetails() {
		return contentDetails;
	}

	public void setContentDetails(List<ContentDetails> contentDetails) {
		this.contentDetails = contentDetails;
	}

}
