package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DuplicateListingResponse extends BaseResponse {
	private String listingId;
	
	public DuplicateListingResponse(){}

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
}
