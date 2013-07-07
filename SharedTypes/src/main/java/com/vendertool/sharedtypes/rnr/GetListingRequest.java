package com.vendertool.sharedtypes.rnr;

public class GetListingRequest extends BaseRequest {

	private String listingId;

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
}