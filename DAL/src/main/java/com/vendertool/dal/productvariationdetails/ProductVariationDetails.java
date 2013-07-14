package com.vendertool.dal.productvariationdetails;

// Generated Jul 6, 2013 10:59:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductVariationDetails generated by hbm2java
 */
@Entity
@Table(name = "PRODUCT_VARIATION_DETAILS", catalog = "PRODUCTDB")
public class ProductVariationDetails implements java.io.Serializable {

	private long productVariationDetailsId;
	private Long productVariationId;
	private String variationName;
	private String variationValues;
	private Date createDate;

	public ProductVariationDetails() {
	}

	public ProductVariationDetails(long productVariationDetailsId) {
		this.productVariationDetailsId = productVariationDetailsId;
	}

	public ProductVariationDetails(long productVariationDetailsId,
			Long productVariationId, String variationName,
			String variationValues, Date createDate) {
		this.productVariationDetailsId = productVariationDetailsId;
		this.productVariationId = productVariationId;
		this.variationName = variationName;
		this.variationValues = variationValues;
		this.createDate = createDate;
	}

	@Id
	@Column(name = "PRODUCT_VARIATION_DETAILS_ID", unique = true, nullable = false)
	public long getProductVariationDetailsId() {
		return this.productVariationDetailsId;
	}

	public void setProductVariationDetailsId(long productVariationDetailsId) {
		this.productVariationDetailsId = productVariationDetailsId;
	}

	@Column(name = "PRODUCT_VARIATION_ID")
	public Long getProductVariationId() {
		return this.productVariationId;
	}

	public void setProductVariationId(Long productVariationId) {
		this.productVariationId = productVariationId;
	}

	@Column(name = "VARIATION_NAME", length = 45)
	public String getVariationName() {
		return this.variationName;
	}

	public void setVariationName(String variationName) {
		this.variationName = variationName;
	}

	@Column(name = "VARIATION_VALUES", length = 45)
	public String getVariationValues() {
		return this.variationValues;
	}

	public void setVariationValues(String variationValues) {
		this.variationValues = variationValues;
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
