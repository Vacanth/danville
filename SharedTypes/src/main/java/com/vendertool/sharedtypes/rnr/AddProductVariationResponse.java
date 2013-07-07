package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddProductVariationResponse extends BaseResponse {
	private String variationId;
	
	public AddProductVariationResponse(){}

	public String getVariationId() {
		return variationId;
	}

	public void setVariationId(String variationId) {
		this.variationId = variationId;
	}
}
