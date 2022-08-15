package com.dialogflow.dialogflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentData {

	private long csContentDataId;
	private long csContentId;
	private String name;
	private String value;

	public long getCsContentDataId() {
		return csContentDataId;
	}

	public void setCsContentDataId(long csContentDataId) {
		this.csContentDataId = csContentDataId;
	}

	public long getCsContentId() {
		return csContentId;
	}

	public void setCsContentId(long csContentId) {
		this.csContentId = csContentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
