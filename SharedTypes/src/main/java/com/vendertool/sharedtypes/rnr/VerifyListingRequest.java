package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Listing;

@XmlRootElement
public class VerifyListingRequest extends BaseRequest {
	private Listing listing;
	
	public VerifyListingRequest(){}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
}
