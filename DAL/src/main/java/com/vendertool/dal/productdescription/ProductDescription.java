package com.vendertool.dal.productdescription;

// Generated Jul 6, 2013 10:59:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductDescription generated by hbm2java
 */
@Entity
@Table(name = "product_description", catalog = "productdb")
public class ProductDescription implements java.io.Serializable {

	private long productDescriptionId;
	private String descriptionName;
	private long productId;
	private String descriptionText;
	private Date createdDate;
	private Date lastModifiedDate;

	public ProductDescription() {
	}

	public ProductDescription(long productDescriptionId, long productId) {
		this.productDescriptionId = productDescriptionId;
		this.productId = productId;
	}

	public ProductDescription(long productDescriptionId,
			String descriptionName, long productId, String descriptionText,
			Date createdDate, Date lastModifiedDate) {
		this.productDescriptionId = productDescriptionId;
		this.descriptionName = descriptionName;
		this.productId = productId;
		this.descriptionText = descriptionText;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Id
	@Column(name = "PRODUCT_DESCRIPTION_ID", unique = true, nullable = false)
	public long getProductDescriptionId() {
		return this.productDescriptionId;
	}

	public void setProductDescriptionId(long productDescriptionId) {
		this.productDescriptionId = productDescriptionId;
	}

	@Column(name = "DESCRIPTION_NAME", length = 64)
	public String getDescriptionName() {
		return this.descriptionName;
	}

	public void setDescriptionName(String descriptionName) {
		this.descriptionName = descriptionName;
	}

	@Column(name = "PRODUCT_ID", nullable = false)
	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Column(name = "DESCRIPTION_TEXT", length = 65535)
	public String getDescriptionText() {
		return this.descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
