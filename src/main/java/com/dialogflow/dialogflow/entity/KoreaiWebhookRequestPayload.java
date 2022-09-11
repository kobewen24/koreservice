package com.dialogflow.dialogflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KoreaiWebhookRequestPayload {
	
	private Long userId;
	private Long segmentId;
	private Integer siteId;
	private Long sessionId;
	private String docId;
	private JsonNode itempicker;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getSegmentId() {
		return segmentId;
	}
	public void setSegmentId(Long segmentId) {
		this.segmentId = segmentId;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public JsonNode getItempicker() {
		return itempicker;
	}
	public void setItempicker(JsonNode itempicker) {
		this.itempicker = itempicker;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	

}
