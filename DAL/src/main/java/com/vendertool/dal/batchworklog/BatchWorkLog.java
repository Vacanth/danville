package com.vendertool.dal.batchworklog;
// default package
// Generated Jul 20, 2013 2:10:06 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BatchWorkLog generated by hbm2java
 */
public class BatchWorkLog implements java.io.Serializable {

	private long batchWorkLogId;
	private long batchId;
	private long fileId;
	private Long accountId;
	private Long recordId;
	private byte[] request;
	private byte[] response;
	private Byte status;
	private String apiAction;
	private Integer siteId;
	private Date createdDate;
	private Date lastModifiedDate;

	public BatchWorkLog() {
	}

	public BatchWorkLog(long batchWorkLogId, long batchId, long fileId) {
		this.batchWorkLogId = batchWorkLogId;
		this.batchId = batchId;
		this.fileId = fileId;
	}

	public BatchWorkLog(long batchWorkLogId, long batchId, long fileId,
			Long accountId, Long recordId, byte[] request, byte[] response,
			Byte status, String apiAction, Integer siteId, Date createdDate,
			Date lastModifiedDate) {
		this.batchWorkLogId = batchWorkLogId;
		this.batchId = batchId;
		this.fileId = fileId;
		this.accountId = accountId;
		this.recordId = recordId;
		this.request = request;
		this.response = response;
		this.status = status;
		this.apiAction = apiAction;
		this.siteId = siteId;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public long getBatchWorkLogId() {
		return this.batchWorkLogId;
	}

	public void setBatchWorkLogId(long batchWorkLogId) {
		this.batchWorkLogId = batchWorkLogId;
	}

	public long getBatchId() {
		return this.batchId;
	}

	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}

	public long getFileId() {
		return this.fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public byte[] getRequest() {
		return this.request;
	}

	public void setRequest(byte[] request) {
		this.request = request;
	}

	public byte[] getResponse() {
		return this.response;
	}

	public void setResponse(byte[] response) {
		this.response = response;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getApiAction() {
		return this.apiAction;
	}

	public void setApiAction(String apiAction) {
		this.apiAction = apiAction;
	}

	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
