package com.vendertool.sharedtypes.core;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class Product{
	private String productId;
	private String title;
	private String description;
	private String sku;
	private Amount price;
	private ProductCodeTypeEnum productCodeType;
	private String productCode;
	private int quantity;
	private Weight weight;
	private Dimension dimension;
	private List<Image> images;
	private List<NameValuePair> properties;
	private List<ProductVariation> variations;
	private Date createDate;
	private Date lastModifiedDate;
	private String createOwnerId;
	
	
	public Product(){}
	
	public Product(String title){
		setTitle(title);
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title) {
		if((title == null) || (title.trim().length() <= 0)){
			throw new RuntimeException("invalid product title");
		}
		this.title = title;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String toString() {
		return "PRODUCT ID = '" + productId + "'; TITLE = '" + title + "'";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Amount getPrice() {
		return price;
	}

	public void setPrice(Amount price) {
		this.price = price;
	}

	public ProductCodeTypeEnum getProductCodeType() {
		return productCodeType;
	}

	public void setProductCodeType(ProductCodeTypeEnum productCodeType) {
		this.productCodeType = productCodeType;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<NameValuePair> getProperties() {
		return properties;
	}

	public void setProperties(List<NameValuePair> properties) {
		this.properties = properties;
	}

	public List<ProductVariation> getVariations() {
		return variations;
	}

	public void setVariations(List<ProductVariation> variations) {
		this.variations = variations;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreateOwnerId() {
		return createOwnerId;
	}

	public void setCreateOwnerId(String createOwnerId) {
		this.createOwnerId = createOwnerId;
	}
}
