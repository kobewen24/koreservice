package com.dialogflow.dialogflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentTags {

	private String referenceKey;
	private String localizedContentTag;

	public String getReferenceKey() {
		return referenceKey;
	}

	public void setReferenceKey(String referenceKey) {
		this.referenceKey = referenceKey;
	}

	public String getLocalizedContentTag() {
		return localizedContentTag;
	}

	public void setLocalizedContentTag(String localizedContentTag) {
		this.localizedContentTag = localizedContentTag;
	}
}
