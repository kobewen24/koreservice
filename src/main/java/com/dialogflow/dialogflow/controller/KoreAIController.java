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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/koreai")
public class KoreAIController{
	
	private String inr_itempicker_doc = "{\"rLogId\":\"t6hheiwvpd1%28ciuc1mlnm2%3Asn%3D9ipthheiwvpd1%28%60%7F1au*w%60ut3457-1829fbc5556-0x2340\",\"success\":true,\"documentId\":[\"BOTC4013\"],\"preferredLanguageLocale\":\"en_US\",\"siteId\":0,\"contentDetails\":[{\"documentId\":\"BOTC4013\",\"localeId\":\"en_US\",\"documentType\":\"BOT_CONTENT\",\"cacheVersion\":1807,\"contentData\":[{\"name\":\"BOT_CONTENT.TITLE\",\"value\":\"inr.1-inr_entry - guest user\"},{\"name\":\"BOT_CONTENT.DISPLAY_TITLE\",\"value\":\"Item hasn't arrived\"},{\"name\":\"BOT_CONTENT.DESKTOP\",\"value\":\"<div>So I can best guide you, please select one of the options below:</div>\\n\\n<div class=\\\"button_group\\\">\\n<div>My order hasn&#39;t arrived</div>\\n\\n<div>Help a buyer with an item that hasn&#39;t arrived</div>\\n</div>\\n\"},{\"name\":\"BOT_CONTENT.MOBILE_WEB\",\"value\":\"<div>So I can best guide you, please select one of the options below:</div>\\n\\n<div class=\\\"button_group\\\">\\n<div>My order hasn&#39;t arrived</div>\\n\\n<div>Help a buyer with an item that hasn&#39;t arrived</div>\\n</div>\\n\"},{\"name\":\"BOT_CONTENT.TOPIC_ID\",\"value\":\"4042\"}],\"contentTags\":[]}]}";
	private String itemPicker = "[{\"type\":\"html\",\"payload\":{\"html\":\"OK, qibuk, if an item you bought or sold hasn't arrived yet, we'll help you sort this out. Just a sec while I check your recent purchases and sold items.\"},\"source\":\"BOTC3598\"},{\"type\":\"html\",\"payload\":{\"html\":\"Right, choose the one that hasn't arrived.\"},\"source\":\"BOTC3598\"},{\"type\":\"template\",\"payload\":{\"template\":{\"name\":\"itempickerTemplate\",\"type\":\"multiple_itempicker\",\"widgets\":[{\"dropdown\":{\"key\":\"topicId\",\"defaultValue\":\"2925\",\"options\":[{\"name\":\"All\",\"value\":\"2925\"},{\"name\":\"Purchases\",\"value\":\"4042\"},{\"name\":\"Sold\",\"value\":\"4128\"}],\"action\":{\"itemPicker\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/itempicker\",\"method\":\"POST\",\"parameters\":[{\"key\":\"pageNumber\",\"value\":\"${pageNumber}\"},{\"key\":\"topicId\",\"value\":\"${topicId}\"},{\"key\":\"itemEntity\",\"value\":\"${itemEntity}\"}]}}}},{\"searchInput\":{\"key\":\"itemEntity\",\"placeholder\":\"Search by item details\",\"action\":{\"itemPicker\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/itempicker\",\"method\":\"POST\",\"parameters\":[{\"key\":\"pageNumber\",\"value\":\"${pageNumber}\"},{\"key\":\"topicId\",\"value\":\"${topicId}\"},{\"key\":\"itemEntity\",\"value\":\"${itemEntity}\"}]}}}}],\"items\":{\"status\":\"OK\",\"total\":3,\"currentPage\":1,\"displayNum\":10,\"dataSet\":[{\"title\":{\"value\":\"DCP -- 3-FixedPrice Item1635273197415-1635273197415**704e7902-b038-4025-a75f-04b\"},\"itemId\":{\"value\":\"200080334757\"},\"transactionId\":{\"value\":\"28646582010\"},\"saleDate\":{\"value\":\"02/09/22\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/v9gAAOSw1kViBLUo/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"26-00026-06874\"}},{\"title\":{\"value\":\"DCP -- 3-FixedPrice Item1635273197415-1635273197415**7ba8a928-dfd7-486c-ad85-3fb\"},\"itemId\":{\"value\":\"200080334741\"},\"transactionId\":{\"value\":\"28646576010\"},\"saleDate\":{\"value\":\"02/09/22\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/v8AAAOSw1kViBLRI/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"24-00025-76888\"}},{\"title\":{\"value\":\"DCP -- **f18ef735-1b30-48f1-9adc-dd605bb5ad4aUK Fixed Price Best Offer        \"},\"itemId\":{\"value\":\"200080334135\"},\"transactionId\":{\"value\":\"28646507010\"},\"saleDate\":{\"value\":\"02/09/22\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/FUIAAOSwpbpiBKhB/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"18-00026-29996\"}}],\"action\":{\"botTracking\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/botTracking\",\"method\":\"POST\",\"parameters\":[{\"key\":\"operation\",\"value\":\"itemPickerTracking\"},{\"key\":\"clientContext\",\"value\":\"{\\\"from\\\":\\\"helphub\\\",\\\"clientInfo\\\":{\\\"channelTopicId\\\":\\\"4041\\\",\\\"pageId\\\":\\\"2493094\\\",\\\"appId\\\":\\\"-1\\\",\\\"isAsync\\\":false,\\\"isContactUs\\\":true,\\\"guestContinue\\\":false,\\\"botId\\\":1645428631411,\\\"enableHearingImpairedLink\\\":true}}\"},{\"key\":\"attributeMap\",\"value\":\"{\\\"ITEM_PICKER_CLICKED\\\":\\\"1\\\",\\\"guid\\\":\\\"1b028b6317fc0a857017f105ffffff61\\\"}\"}]},\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"event\":\"display_yes\",\"parameters\":[{\"key\":\"itemId\",\"value\":\"${itemId}\"},{\"key\":\"transactionId\",\"value\":\"${transactionId}\"}]},\"postMessage\":{\"actionPayloadType\":\"postMessageType\",\"elements\":[{\"type\":\"html\",\"payload\":{\"html\":\"Checking on...\"},\"source\":null}]}}},\"action\":{\"itemPicker\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/itempicker\",\"method\":\"POST\",\"parameters\":[{\"key\":\"pageNumber\",\"value\":\"${pageNumber}\"},{\"key\":\"topicId\",\"value\":\"${topicId}\"},{\"key\":\"itemEntity\",\"value\":\"${itemEntity}\"}]}}}},\"source\":\"BOTC3598\"},{\"type\":\"quick_replies\",\"payload\":{\"quick_replies\":[{\"type\":\"post_back\",\"title\":\"Don't see item\",\"action\":{\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"text\":\"Don't see item\",\"parameters\":[]}}},{\"type\":\"post_back\",\"title\":\"Stop this\",\"action\":{\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"text\":\"Stop this\",\"parameters\":[]}}}]},\"source\":\"BOTC3598\"}]";
	@GetMapping(value="/getContentDetail/{docId}/{siteId}")
	@ResponseBody
	public ContentTemplateResponse getContentDetail(@PathVariable("docId") String docId, @PathVariable("siteId") String siteId) throws Exception {
		ContentTemplateResponse response = new ObjectMapper().readValue(inr_itempicker_doc, ContentTemplateResponse.class);
		return response;
		
	}
	
	@GetMapping(value="/getItempicker")
	@ResponseBody
	public Integer getItempicker() throws Exception {
		return 2;
		
	}
	
	@GetMapping(value="/getItempickerContent")
	@ResponseBody
	public String getItempickerContent() throws Exception {
		return itemPicker;
		
	}

}
