package com.dialogflow.dialogflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KoreaiWebhookRequest {
	
	@JsonProperty("type")
	private String type;
	private String name;
	private KoreaiWebhookRequestPayload payload;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public KoreaiWebhookRequestPayload getPayload() {
		return payload;
	}
	public void setPayload(KoreaiWebhookRequestPayload payload) {
		this.payload = payload;
	}
	
	

}
