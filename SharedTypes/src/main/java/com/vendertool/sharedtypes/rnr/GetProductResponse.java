package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Product;


@XmlRootElement
public class GetProductResponse extends BaseResponse {
	private Product product;

	public GetProductResponse(){}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
