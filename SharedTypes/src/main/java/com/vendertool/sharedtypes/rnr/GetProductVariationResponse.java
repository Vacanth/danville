package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.ProductVariation;

@XmlRootElement
public class GetProductVariationResponse extends BaseResponse {
	private ProductVariation variation;
	
	public GetProductVariationResponse(){}

	public ProductVariation getVariation() {
		return variation;
	}

	public void setVariation(ProductVariation variation) {
		this.variation = variation;
	}
}
