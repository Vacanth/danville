package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ShippingServiceEnum {
	USPS_EXPRESS_MAIL_FLAT_RATE_BOX(1, "USPS Express Mail Flat Rate Box"),
	USPS_EXPRESS_MAIL_FLAT_RATE_ENVELOPE(2, "USPS Express Mail Flat Envelope");
	
	private int id;
	private String name;
	
	ShippingServiceEnum(int id, String name){
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
