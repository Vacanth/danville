package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Amount;

@XmlRootElement
public class GetListingPriceQuantityResponse extends BaseResponse {
	private String listingId;
	private Amount price;
	private int quantity;
	
	public GetListingPriceQuantityResponse(){}

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
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
