package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomShippingDetails {
	private String customeService;
	private Amount cost;
	
	public CustomShippingDetails(){}

	public String getCustomeService() {
		return customeService;
	}

	public void setCustomeService(String customeService) {
		this.customeService = customeService;
	}

	public Amount getCost() {
		return cost;
	}

	public void setCost(Amount cost) {
		this.cost = cost;
	}
}
