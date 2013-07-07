package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Amount;

@XmlRootElement
public class UpdateProductPriceQuantityRequest extends BaseRequest {
	private String productId;
	private Amount price;
	private int quantity;
	
	public UpdateProductPriceQuantityRequest(){}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Amount getPrice() {
		return price;
	}

	public void setPrice(Amount price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
