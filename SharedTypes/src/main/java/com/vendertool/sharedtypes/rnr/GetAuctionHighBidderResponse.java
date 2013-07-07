package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetAuctionHighBidderResponse extends BaseResponse {
	private String highBidderAccountId;
	
	public GetAuctionHighBidderResponse(){}

	public String getHighBidderAccountId() {
		return highBidderAccountId;
	}

	public void setHighBidderAccountId(String highBidderAccountId) {
		this.highBidderAccountId = highBidderAccountId;
	}
}
