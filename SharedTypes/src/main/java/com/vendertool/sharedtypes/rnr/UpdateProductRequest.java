package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Product;

@XmlRootElement
public class UpdateProductRequest extends BaseRequest {
	private Product product;
	
	public UpdateProductRequest(){}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
