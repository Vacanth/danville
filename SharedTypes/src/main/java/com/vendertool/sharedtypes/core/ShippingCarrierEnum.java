package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ShippingCarrierEnum {
	USPS(1, "USPS"),
	FedEx(2, "FedEx"), 
	UPS (3, "UPS"), 
	ONTRAC(4, "ONTRAC"),
	DHL(5, "DHL");
	
	private int id;
	private String name;
	
	ShippingCarrierEnum(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
