package com.vendertool.sharedtypes.rnr;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.ListingFee;

@XmlRootElement
public class VerifyListingResponse extends BaseResponse {
	private List<ListingFee> fees;
	
	public VerifyListingResponse(){}

	public List<ListingFee> getFees() {
		return fees;
	}

	public void setFees(List<ListingFee> fees) {
		this.fees = fees;
	}
}
