package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Listing;

@XmlRootElement
public class UpdateListingRequest extends BaseRequest {
	private Listing listing;
	
	public UpdateListingRequest(){}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
}
