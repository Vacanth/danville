package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.ProductVariation;

@XmlRootElement
public class AddProductVariationRequest extends BaseRequest {
	private String productId;
	private ProductVariation variation;
	
	public AddProductVariationRequest(){}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductVariation getVariation() {
		return variation;
	}

	public void setVariation(ProductVariation variation) {
		this.variation = variation;
	}
}
