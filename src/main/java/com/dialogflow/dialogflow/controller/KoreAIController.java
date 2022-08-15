package com.dialogflow.dialogflow.controller;

import com.dialogflow.dialogflow.entity.ContentTemplateResponse;
import com.dialogflow.dialogflow.entity.PageInfo;
import com.dialogflow.dialogflow.entity.ResponseMessage;
import com.dialogflow.dialogflow.entity.WebhookRequest;
import com.dialogflow.dialogflow.entity.WebhookResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/koreai")
public class KoreAIController{
	
	private String inr_itempicker_doc = "{\"rLogId\":\"t6hheiwvpd1%28ciuc1mlnm2%3Asn%3D9ipthheiwvpd1%28%60%7F1au*w%60ut3457-1829fbc5556-0x2340\",\"success\":true,\"documentId\":[\"BOTC4013\"],\"preferredLanguageLocale\":\"en_US\",\"siteId\":0,\"contentDetails\":[{\"documentId\":\"BOTC4013\",\"localeId\":\"en_US\",\"documentType\":\"BOT_CONTENT\",\"cacheVersion\":1807,\"contentData\":[{\"name\":\"BOT_CONTENT.TITLE\",\"value\":\"inr.1-inr_entry - guest user\"},{\"name\":\"BOT_CONTENT.DISPLAY_TITLE\",\"value\":\"Item hasn't arrived\"},{\"name\":\"BOT_CONTENT.DESKTOP\",\"value\":\"<div>So I can best guide you, please select one of the options below:</div>\\n\\n<div class=\\\"button_group\\\">\\n<div>My order hasn&#39;t arrived</div>\\n\\n<div>Help a buyer with an item that hasn&#39;t arrived</div>\\n</div>\\n\"},{\"name\":\"BOT_CONTENT.MOBILE_WEB\",\"value\":\"<div>So I can best guide you, please select one of the options below:</div>\\n\\n<div class=\\\"button_group\\\">\\n<div>My order hasn&#39;t arrived</div>\\n\\n<div>Help a buyer with an item that hasn&#39;t arrived</div>\\n</div>\\n\"},{\"name\":\"BOT_CONTENT.TOPIC_ID\",\"value\":\"4042\"}],\"contentTags\":[]}]}";
	
	@GetMapping(value="/getContentDetail/{docId}/{siteId}")
	@ResponseBody
	public ContentTemplateResponse endConversation(@PathVariable("docId") String docId, @PathVariable("siteId") String siteId) throws Exception {
		ContentTemplateResponse response = new ObjectMapper().readValue(inr_itempicker_doc, ContentTemplateResponse.class);
		return response;
		
	}

}
