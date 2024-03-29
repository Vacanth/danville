package com.vendertool.dal.subscriptiondetail;

// Generated Jul 6, 2013 10:59:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SubscriptionDetail generated by hbm2java
 */
@Entity
@Table(name = "subscription_detail", catalog = "productdb")
public class SubscriptionDetail implements java.io.Serializable {

	private long subscriptionId;
	private String subscriptionName;
	private Long descriptionCode;
	private Date modifyDate;
	private String changeWho;
	private Date createDate;

	public SubscriptionDetail() {
	}

	public SubscriptionDetail(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public SubscriptionDetail(long subscriptionId, String subscriptionName,
			Long descriptionCode, Date modifyDate, String changeWho,
			Date createDate) {
		this.subscriptionId = subscriptionId;
		this.subscriptionName = subscriptionName;
		this.descriptionCode = descriptionCode;
		this.modifyDate = modifyDate;
		this.changeWho = changeWho;
		this.createDate = createDate;
	}

	@Id
	@Column(name = "SUBSCRIPTION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	public long getSubscriptionId() {
		return this.subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@Column(name = "SUBSCRIPTION_NAME", length = 64)
	public String getSubscriptionName() {
		return this.subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	@Column(name = "DESCRIPTION_CODE", precision = 18, scale = 0)
	public Long getDescriptionCode() {
		return this.descriptionCode;
	}

	public void setDescriptionCode(Long descriptionCode) {
		this.descriptionCode = descriptionCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE", length = 19)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "CHANGE_WHO", length = 45)
	public String getChangeWho() {
		return this.changeWho;
	}

	public void setChangeWho(String changeWho) {
		this.changeWho = changeWho;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
