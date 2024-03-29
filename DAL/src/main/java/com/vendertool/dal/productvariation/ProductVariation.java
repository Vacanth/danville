package com.vendertool.dal.productvariation;

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
 * ProductVariation generated by hbm2java
 */
@Entity
@Table(name = "product_variation", catalog = "productdb")
public class ProductVariation implements java.io.Serializable {

	private long productVariationsId;
	private Long productId;
	private Integer availbleQuantity;
	private BigDecimal price;
	private Date lastModifiedDate;
	private Date createDate;

	public ProductVariation() {
	}

	public ProductVariation(long productVariationsId) {
		this.productVariationsId = productVariationsId;
	}

	public ProductVariation(long productVariationsId, Long productId,
			Integer availbleQuantity, BigDecimal price, Date lastModifiedDate,
			Date createDate) {
		this.productVariationsId = productVariationsId;
		this.productId = productId;
		this.availbleQuantity = availbleQuantity;
		this.price = price;
		this.lastModifiedDate = lastModifiedDate;
		this.createDate = createDate;
	}

	@Id
	@Column(name = "PRODUCT_VARIATIONS_ID", unique = true, nullable = false)
	public long getProductVariationsId() {
		return this.productVariationsId;
	}

	public void setProductVariationsId(long productVariationsId) {
		this.productVariationsId = productVariationsId;
	}

	@Column(name = "PRODUCT_ID")
	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Column(name = "AVAILBLE_QUANTITY")
	public Integer getAvailbleQuantity() {
		return this.availbleQuantity;
	}

	public void setAvailbleQuantity(Integer availbleQuantity) {
		this.availbleQuantity = availbleQuantity;
	}

	@Column(name = "PRICE", precision = 18, scale = 4)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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
