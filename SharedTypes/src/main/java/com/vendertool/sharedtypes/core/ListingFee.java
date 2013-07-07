package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListingFee {
	 private String feeType;
	 private Amount fee;
	 
	 public ListingFee(){}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Amount getFee() {
		return fee;
	}

	public void setFee(Amount fee) {
		this.fee = fee;
	}
}
