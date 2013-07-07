package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnPolicy {
	
	@XmlEnum
	public enum ReturnShippingPayerTypeEnum{
		SELLER, BUYER, MARKET_PLATFORM;
	}
	
	private int policyId;
	private String policyName;
	private int returnDuration;
	private String policy;
	private Address address;
	private ReturnShippingPayerTypeEnum payer;
	
	public ReturnPolicy(){}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getReturnDuration() {
		return returnDuration;
	}

	public void setReturnDuration(int returnDuration) {
		this.returnDuration = returnDuration;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ReturnShippingPayerTypeEnum getPayer() {
		return payer;
	}

	public void setPayer(ReturnShippingPayerTypeEnum payer) {
		this.payer = payer;
	}
}
