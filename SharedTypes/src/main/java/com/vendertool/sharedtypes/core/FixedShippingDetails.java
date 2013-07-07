package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class FixedShippingDetails {
	private ShippingCarrierEnum carrier;
	private ShippingServiceEnum service;
	private Amount cost;
	
	public FixedShippingDetails(){}

	public ShippingCarrierEnum getCarrier() {
		return carrier;
	}

	public void setCarrier(ShippingCarrierEnum carrier) {
		this.carrier = carrier;
	}

	public ShippingServiceEnum getService() {
		return service;
	}

	public void setService(ShippingServiceEnum service) {
		this.service = service;
	}

	public Amount getCost() {
		return cost;
	}

	public void setCost(Amount cost) {
		this.cost = cost;
	}
}
