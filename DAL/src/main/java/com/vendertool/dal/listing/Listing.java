package com.vendertool.dal.listing;

// Generated Jul 6, 2013 10:59:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Listing generated by hbm2java
 */
@Entity
@Table(name = "listing", catalog = "productdb")
public class Listing implements java.io.Serializable {

	private long listingId;
	private String title;
	private long refId;
	private Byte refType;
	private Long accountId;
	private Long shippingPolicyId;
	private Long returnPolicyId;
	private Long locationPolicyId;
	private BigDecimal price;
	private Integer quantity;
	private Long clasificationId;
	private String produce;
	private Date createDate;
	private Date lastModifiedDate;
	private String lastModifiedApp;

	public Listing() {
	}

	public Listing(long listingId, long refId) {
		this.listingId = listingId;
		this.refId = refId;
	}

	public Listing(long listingId, String title, long refId, Byte refType,
			Long accountId, Long shippingPolicyId, Long returnPolicyId,
			Long locationPolicyId, BigDecimal price, Integer quantity,
			Long clasificationId, String produce, Date createDate,
			Date lastModifiedDate, String lastModifiedApp) {
		this.listingId = listingId;
		this.title = title;
		this.refId = refId;
		this.refType = refType;
		this.accountId = accountId;
		this.shippingPolicyId = shippingPolicyId;
		this.returnPolicyId = returnPolicyId;
		this.locationPolicyId = locationPolicyId;
		this.price = price;
		this.quantity = quantity;
		this.clasificationId = clasificationId;
		this.produce = produce;
		this.createDate = createDate;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedApp = lastModifiedApp;
	}

	@Id
	@Column(name = "LISTING_ID", unique = true, nullable = false)
	public long getListingId() {
		return this.listingId;
	}

	public void setListingId(long listingId) {
		this.listingId = listingId;
	}

	@Column(name = "TITLE", length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "REF_ID", nullable = false)
	public long getRefId() {
		return this.refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}

	@Column(name = "REF_TYPE")
	public Byte getRefType() {
		return this.refType;
	}

	public void setRefType(Byte refType) {
		this.refType = refType;
	}

	@Column(name = "ACCOUNT_ID")
	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Column(name = "SHIPPING_POLICY_ID")
	public Long getShippingPolicyId() {
		return this.shippingPolicyId;
	}

	public void setShippingPolicyId(Long shippingPolicyId) {
		this.shippingPolicyId = shippingPolicyId;
	}

	@Column(name = "RETURN_POLICY_ID")
	public Long getReturnPolicyId() {
		return this.returnPolicyId;
	}

	public void setReturnPolicyId(Long returnPolicyId) {
		this.returnPolicyId = returnPolicyId;
	}

	@Column(name = "LOCATION_POLICY_ID")
	public Long getLocationPolicyId() {
		return this.locationPolicyId;
	}

	public void setLocationPolicyId(Long locationPolicyId) {
		this.locationPolicyId = locationPolicyId;
	}

	@Column(name = "PRICE", precision = 18, scale = 4)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "QUANTITY")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "CLASIFICATION_ID")
	public Long getClasificationId() {
		return this.clasificationId;
	}

	public void setClasificationId(Long clasificationId) {
		this.clasificationId = clasificationId;
	}

	@Column(name = "PRODUCE", length = 45)
	public String getProduce() {
		return this.produce;
	}

	public void setProduce(String produce) {
		this.produce = produce;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name = "LAST_MODIFIED_APP", length = 45)
	public String getLastModifiedApp() {
		return this.lastModifiedApp;
	}

	public void setLastModifiedApp(String lastModifiedApp) {
		this.lastModifiedApp = lastModifiedApp;
	}

}
