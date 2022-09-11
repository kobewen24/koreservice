package com.dialogflow.dialogflow.controller;

import com.dialogflow.dialogflow.entity.ContentTemplateResponse;
import com.dialogflow.dialogflow.entity.KoreaiWebhookRequest;
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
	private String itemPicker = "{\"source\":\"bot\",\"creationDate\":\"1662886046947\",\"elements\":[{\"type\":\"html\",\"payload\":{\"html\":\"OK, qibus, if an item you bought or sold hasn't arrived yet, we'll help you sort this out. Just a sec while I check your recent purchases and sold items.\"},\"source\":\"BOTC3598\"},{\"type\":\"html\",\"payload\":{\"html\":\"Right, choose the one that hasn't arrived.\"},\"source\":\"BOTC3598\"},{\"type\":\"template\",\"payload\":{\"template\":{\"name\":\"itempickerTemplate\",\"type\":\"multiple_itempicker\",\"widgets\":[{\"dropdown\":{\"key\":\"topicId\",\"defaultValue\":\"2925\",\"options\":[{\"name\":\"All\",\"value\":\"2925\"},{\"name\":\"Purchases\",\"value\":\"4042\"},{\"name\":\"Sold\",\"value\":\"4128\"}],\"action\":{\"itemPicker\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/itempicker\",\"method\":\"POST\",\"parameters\":[{\"key\":\"pageNumber\",\"value\":\"${pageNumber}\"},{\"key\":\"topicId\",\"value\":\"${topicId}\"},{\"key\":\"itemEntity\",\"value\":\"${itemEntity}\"}]}}}},{\"searchInput\":{\"key\":\"itemEntity\",\"placeholder\":\"Search by item details\",\"action\":{\"itemPicker\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/itempicker\",\"method\":\"POST\",\"parameters\":[{\"key\":\"pageNumber\",\"value\":\"${pageNumber}\"},{\"key\":\"topicId\",\"value\":\"${topicId}\"},{\"key\":\"itemEntity\",\"value\":\"${itemEntity}\"}]}}}}],\"items\":{\"status\":\"OK\",\"total\":59,\"currentPage\":1,\"displayNum\":10,\"dataSet\":[{\"title\":{\"value\":\"US-Single item Single seller-1633782758831\"},\"itemId\":{\"value\":\"180022337294\"},\"transactionId\":{\"value\":\"13323096008\"},\"saleDate\":{\"value\":\"08/24/22\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/MjUwWDI1MA==/z/ED4AAOSwHVZhYYvu/$_1.PNG?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**e1dbca8d-29ae-4e\"},\"itemId\":{\"value\":\"180035406708\"},\"transactionId\":{\"value\":\"13279271008\"},\"saleDate\":{\"value\":\"08/16/22\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"01-00032-78313\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**0ff097b0-316a-4d\"},\"itemId\":{\"value\":\"180035406282\"},\"transactionId\":{\"value\":\"13279244008\"},\"saleDate\":{\"value\":\"08/16/22\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"20-00032-33627\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**eb91e901-96b5-49\"},\"itemId\":{\"value\":\"180035406250\"},\"transactionId\":{\"value\":\"13279240008\"},\"saleDate\":{\"value\":\"08/16/22\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"23-00031-91123\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**8c17812f-2fdf-47\"},\"itemId\":{\"value\":\"180035406213\"},\"transactionId\":{\"value\":\"13279238008\"},\"saleDate\":{\"value\":\"08/16/22\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"19-00032-29090\"}},{\"title\":{\"value\":\"0-THOR Long feedback multi-quantity item-1658518138366\"},\"itemId\":{\"value\":\"330032342090\"},\"transactionId\":{\"value\":\"19790536014\"},\"saleDate\":{\"value\":\"08/04/22\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/cT0AAOSwgZJi2vqP/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"0-THOR Long feedback multi-quantity item-1658518138366\"},\"itemId\":{\"value\":\"330032342090\"},\"transactionId\":{\"value\":\"19790439014\"},\"saleDate\":{\"value\":\"08/04/22\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/cT0AAOSwgZJi2vqP/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"0-THOR Long feedback multi-quantity item-1658518138366\"},\"itemId\":{\"value\":\"330032342090\"},\"transactionId\":{\"value\":\"19790438014\"},\"saleDate\":{\"value\":\"08/04/22\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/cT0AAOSwgZJi2vqP/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"A-A-Ron's test item 1\"},\"itemId\":{\"value\":\"180034030860\"},\"transactionId\":{\"value\":\"13168768008\"},\"saleDate\":{\"value\":\"07/27/22\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"US Motors PicturePack 2 : 1212034397\"},\"itemId\":{\"value\":\"160017227921\"},\"transactionId\":{\"value\":\"12998894006\"},\"saleDate\":{\"value\":\"07/27/22\"},\"pictureUrl\":{\"value\":\"http://i.ebayimg.com/00/s/NDgwWDY0MA==/z/ueoAAOSwj0NUjEhr/$_1.JPG?set_id=8800005007\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"Title123387783793800590\"},\"itemId\":{\"value\":\"160023062646\"},\"transactionId\":{\"value\":\"12998859006\"},\"saleDate\":{\"value\":\"07/27/22\"},\"pictureUrl\":{\"value\":\"http://i.qa.ebayimg.com/images/g/pJ0AAOSwOrlYteLV/s-l1600.jpg\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"Title364881689041100690\"},\"itemId\":{\"value\":\"160023432950\"},\"transactionId\":{\"value\":\"12997810006\"},\"saleDate\":{\"value\":\"07/25/22\"},\"pictureUrl\":{\"value\":\"http://i.qa.ebayimg.com/images/g/pJ0AAOSwOrlYteLV/s-l1600.jpg\"},\"quantity\":{\"value\":\"1\"}}],\"action\":{\"botTracking\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/botTracking\",\"method\":\"POST\",\"parameters\":[{\"key\":\"operation\",\"value\":\"itemPickerTracking\"},{\"key\":\"clientContext\",\"value\":\"{\\\"from\\\":\\\"helphub\\\",\\\"clientInfo\\\":{\\\"channelTopicId\\\":\\\"4041\\\",\\\"pageId\\\":\\\"2493094\\\",\\\"appId\\\":\\\"-1\\\",\\\"isAsync\\\":false,\\\"isContactUs\\\":true,\\\"guestContinue\\\":false,\\\"botId\\\":1662886023774,\\\"enableHearingImpairedLink\\\":false}}\"},{\"key\":\"attributeMap\",\"value\":\"{\\\"ITEM_PICKER_CLICKED\\\":\\\"1\\\",\\\"guid\\\":\\\"fd2f977c1820a64ce88da427ff4914a1\\\"}\"}]},\"postMessage\":{\"actionPayloadType\":\"postMessageType\",\"elements\":[{\"type\":\"html\",\"payload\":{\"html\":\"Checking on...\"},\"source\":null}]},\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"event\":\"inr_display_yes\",\"parameters\":[{\"key\":\"itemId\",\"value\":\"${itemId}\"},{\"key\":\"transactionId\",\"value\":\"${transactionId}\"}]}}},\"action\":{\"itemPicker\":{\"actionPayloadType\":\"ajaxCallType\",\"url\":\"/helpbot/v1/itempicker\",\"method\":\"POST\",\"parameters\":[{\"key\":\"pageNumber\",\"value\":\"${pageNumber}\"},{\"key\":\"topicId\",\"value\":\"${topicId}\"},{\"key\":\"itemEntity\",\"value\":\"${itemEntity}\"}]}}}},\"source\":\"BOTC3598\"},{\"type\":\"quick_replies\",\"payload\":{\"quick_replies\":[{\"type\":\"post_back\",\"title\":\"Don't see item\",\"action\":{\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"text\":\"Don't see item\",\"parameters\":[]}}},{\"type\":\"post_back\",\"title\":\"Stop this\",\"action\":{\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"text\":\"Stop this\",\"parameters\":[]}}}]},\"source\":\"BOTC3598\"}]}";
	private String siteFlowInr = "<div>\n Hmm, ##user_name##. The buyer hasn't yet told us that they didn't get the item.\n</div>\n<div>\n If they report it, we'll let you know what you need to do. <a href=\"http://www.##env##/help/selling/managing-returns-refunds/help-buyer-item-didnt-receive?id=4116\" target=\"_blank\">Learn more<span class=\"g-hdn\"> - opens in new window or tab</span></a>.\n</div>";
	private String itempickerResponse = "{\"items\":{\"status\":\"OK\",\"total\":59,\"currentPage\":1,\"displayNum\":10,\"dataSet\":[{\"title\":{\"value\":\"US-Single item Single seller-1633782758831\"},\"itemId\":{\"value\":\"180022337294\"},\"transactionId\":{\"value\":\"13323096008\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/MjUwWDI1MA==/z/ED4AAOSwHVZhYYvu/$_1.PNG?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**e1dbca8d-29ae-4e\"},\"itemId\":{\"value\":\"180035406708\"},\"transactionId\":{\"value\":\"13279271008\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"01-00032-78313\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**0ff097b0-316a-4d\"},\"itemId\":{\"value\":\"180035406282\"},\"transactionId\":{\"value\":\"13279244008\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"20-00032-33627\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**eb91e901-96b5-49\"},\"itemId\":{\"value\":\"180035406250\"},\"transactionId\":{\"value\":\"13279240008\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"23-00031-91123\"}},{\"title\":{\"value\":\"DCP -- DCP Fixed Price calculated shipping with insurance Test**8c17812f-2fdf-47\"},\"itemId\":{\"value\":\"180035406213\"},\"transactionId\":{\"value\":\"13279238008\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"},\"uniqueOrderId\":{\"value\":\"19-00032-29090\"}},{\"title\":{\"value\":\"0-THOR Long feedback multi-quantity item-1658518138366\"},\"itemId\":{\"value\":\"330032342090\"},\"transactionId\":{\"value\":\"19790536014\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/cT0AAOSwgZJi2vqP/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"0-THOR Long feedback multi-quantity item-1658518138366\"},\"itemId\":{\"value\":\"330032342090\"},\"transactionId\":{\"value\":\"19790439014\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/cT0AAOSwgZJi2vqP/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"0-THOR Long feedback multi-quantity item-1658518138366\"},\"itemId\":{\"value\":\"330032342090\"},\"transactionId\":{\"value\":\"19790438014\"},\"pictureUrl\":{\"value\":\"https://i.qa.ebayimg.com/00/s/NDVYMTEw/z/cT0AAOSwgZJi2vqP/$_1.GIF?set_id=8800004005\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"A-A-Ron's test item 1\"},\"itemId\":{\"value\":\"180034030860\"},\"transactionId\":{\"value\":\"13168768008\"},\"pictureUrl\":{\"value\":\"http://pics.ebaystatic.com/aw/pics/logo/logoEbay_x45.gif\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"US Motors PicturePack 2 : 1212034397\"},\"itemId\":{\"value\":\"160017227921\"},\"transactionId\":{\"value\":\"12998894006\"},\"pictureUrl\":{\"value\":\"http://i.ebayimg.com/00/s/NDgwWDY0MA==/z/ueoAAOSwj0NUjEhr/$_1.JPG?set_id=8800005007\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"Title123387783793800590\"},\"itemId\":{\"value\":\"160023062646\"},\"transactionId\":{\"value\":\"12998859006\"},\"pictureUrl\":{\"value\":\"http://i.qa.ebayimg.com/images/g/pJ0AAOSwOrlYteLV/s-l1600.jpg\"},\"quantity\":{\"value\":\"1\"}},{\"title\":{\"value\":\"Title364881689041100690\"},\"itemId\":{\"value\":\"160023432950\"},\"transactionId\":{\"value\":\"12997810006\"},\"pictureUrl\":{\"value\":\"http://i.qa.ebayimg.com/images/g/pJ0AAOSwOrlYteLV/s-l1600.jpg\"},\"quantity\":{\"value\":\"1\"}}],\"action\":{}},\"filters\":{\"All\":\"2925\",\"Purchases\":\"4042\",\"Sold\":\"4128\"}}\r\n" + 
			"";
	private String noItemsContent = "{\"source\":\"bot\",\"creationDate\":\"1662884613648\",\"elements\":[{\"type\":\"html\",\"payload\":{\"html\":\"I didn't find any items you bought or sold from the past 90 days, qibus.\"},\"source\":\"BOTC1099\"},{\"type\":\"html\",\"payload\":{\"html\":\"There are a few different ways to see the other items you bought or sold. Let me know whether you’re a buyer or seller so I can show you how.\"},\"source\":\"BOTC1099\"},{\"type\":\"buttons\",\"payload\":{\"buttons\":[{\"type\":\"post_back\",\"title\":\"I'm a buyer\",\"action\":{\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"text\":\"I'm a buyer\",\"parameters\":[]}}},{\"type\":\"post_back\",\"title\":\"I'm a seller\",\"action\":{\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"text\":\"I'm a seller\",\"parameters\":[]}}}],\"buttonNumber\":3},\"source\":\"BOTC1099\"},{\"type\":\"quick_replies\",\"payload\":{\"quick_replies\":[{\"type\":\"post_back\",\"title\":\"Stop this\",\"action\":{\"sendReply\":{\"actionPayloadType\":\"sendReplyType\",\"text\":\"Stop this\",\"parameters\":[]}}}]},\"source\":\"BOTC1099\"}]}";
	@GetMapping(value="/getContentDetail/{docId}/{siteId}")
	@ResponseBody
	public ContentTemplateResponse getContentDetail(@PathVariable("docId") String docId, @PathVariable("siteId") String siteId) throws Exception {
		String content = "";
		if(docId.equalsIgnoreCase("BOTC1318")) {
			content = siteFlowInr;
		}
		if(docId.equalsIgnoreCase("BOTC4013")) {
			content = inr_itempicker_doc;
		}
		ContentTemplateResponse response = new ObjectMapper().readValue(inr_itempicker_doc, ContentTemplateResponse.class);
		return response;
		
	}
	
	@GetMapping(value="/getItempicker")
	@ResponseBody
	public Integer getItempicker() throws Exception {
		return 2;
		
	}
	
	@GetMapping(value="/getMultiItempickerContent")
	@ResponseBody
	public String getItempickerContent() throws Exception {
		return itemPicker;
		
	}
	
	@PostMapping(value="/actions")
	@ResponseBody
	public JsonNode actions(@RequestBody KoreaiWebhookRequest request) throws Exception {
		String action = request.getName();
		JsonNode jsonNode = null;
		switch(action) {
		   case "action_check_itempicker":
			   jsonNode = new ObjectMapper().readValue(itempickerResponse, JsonNode.class);
			   break;
		   case "action_build_itempicker_card":
			   jsonNode = new ObjectMapper().readValue(itemPicker, JsonNode.class);
			   break;
		   case "action_get_content_detail":
			   String docId = request.getPayload().getDocId();
			   if(docId.equalsIgnoreCase("BOTC1099")) {
				   jsonNode = new ObjectMapper().readValue(noItemsContent, JsonNode.class);
			   }
			   break;
		}
		return jsonNode;
		
	}

}
