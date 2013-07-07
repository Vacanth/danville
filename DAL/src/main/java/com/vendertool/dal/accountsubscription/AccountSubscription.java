package com.vendertool.dal.accountsubscription;

// Generated Jul 7, 2013 3:05:24 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AccountSubscription generated by hbm2java
 */
@Entity
@Table(name = "account_subscription", catalog = "PRODUCTDB")
public class AccountSubscription implements java.io.Serializable {

	private long accountSubscriptionId;
	private long accountId;
	private Integer subscriptionId;
	private Short subscriptionType;
	private Date startDate;
	private Date endDate;
	private Date modifyDate;
	private String changeWho;
	private Date createDate;
	private int discountId;

	public AccountSubscription() {
	}

	public AccountSubscription(long accountSubscriptionId, long accountId,
			int discountId) {
		this.accountSubscriptionId = accountSubscriptionId;
		this.accountId = accountId;
		this.discountId = discountId;
	}

	public AccountSubscription(long accountSubscriptionId, long accountId,
			Integer subscriptionId, Short subscriptionType, Date startDate,
			Date endDate, Date modifyDate, String changeWho, Date createDate,
			int discountId) {
		this.accountSubscriptionId = accountSubscriptionId;
		this.accountId = accountId;
		this.subscriptionId = subscriptionId;
		this.subscriptionType = subscriptionType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifyDate = modifyDate;
		this.changeWho = changeWho;
		this.createDate = createDate;
		this.discountId = discountId;
	}

	@Id
	@Column(name = "ACCOUNT_SUBSCRIPTION_ID", unique = true, nullable = false)
	public long getAccountSubscriptionId() {
		return this.accountSubscriptionId;
	}

	public void setAccountSubscriptionId(long accountSubscriptionId) {
		this.accountSubscriptionId = accountSubscriptionId;
	}

	@Column(name = "ACCOUNT_ID", nullable = false)
	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	@Column(name = "SUBSCRIPTION_ID")
	public Integer getSubscriptionId() {
		return this.subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@Column(name = "SUBSCRIPTION_TYPE", precision = 4, scale = 0)
	public Short getSubscriptionType() {
		return this.subscriptionType;
	}

	public void setSubscriptionType(Short subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	@Column(name = "DISCOUNT_ID", nullable = false)
	public int getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

}
