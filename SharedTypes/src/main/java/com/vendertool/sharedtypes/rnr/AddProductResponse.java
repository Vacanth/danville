package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddProductResponse extends BaseResponse {
	String productId;

	public AddProductResponse(){}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
}
