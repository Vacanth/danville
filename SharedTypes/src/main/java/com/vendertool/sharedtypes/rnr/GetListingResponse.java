package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Listing;

@XmlRootElement
public class GetListingResponse extends BaseResponse {
	private Listing listing;

	public GetListingResponse(){}
	
	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
}
