package com.dialogflow.dialogflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Calendar;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentDetails {

	private long csContentId;
    private String documentId;
    private String localeId;
    private Calendar documentPublishedDate;
    private String documentAuthor;
    private String documentType;
    private String xmlData;
    private int cacheVersion;
    private String contentTextRecordId;
    private List<ContentData> contentData;
    private List<ContentTags> contentTags;
	public long getCsContentId() {
		return csContentId;
	}
	public void setCsContentId(long csContentId) {
		this.csContentId = csContentId;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getLocaleId() {
		return localeId;
	}
	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}
	public Calendar getDocumentPublishedDate() {
		return documentPublishedDate;
	}
	public void setDocumentPublishedDate(Calendar documentPublishedDate) {
		this.documentPublishedDate = documentPublishedDate;
	}
	public String getDocumentAuthor() {
		return documentAuthor;
	}
	public void setDocumentAuthor(String documentAuthor) {
		this.documentAuthor = documentAuthor;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getXmlData() {
		return xmlData;
	}
	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}
	public int getCacheVersion() {
		return cacheVersion;
	}
	public void setCacheVersion(int cacheVersion) {
		this.cacheVersion = cacheVersion;
	}
	public String getContentTextRecordId() {
		return contentTextRecordId;
	}
	public void setContentTextRecordId(String contentTextRecordId) {
		this.contentTextRecordId = contentTextRecordId;
	}
	public List<ContentData> getContentData() {
		return contentData;
	}
	public void setContentData(List<ContentData> contentData) {
		this.contentData = contentData;
	}
	public List<ContentTags> getContentTags() {
		return contentTags;
	}
	public void setContentTags(List<ContentTags> contentTags) {
		this.contentTags = contentTags;
	}
	
    
    
}
