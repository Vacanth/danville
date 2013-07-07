package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum VTErrorDomainEnum {
	UNKNOWN(0, "UNKNOWN"),
	SYSTEM(1, "SYSTEM"),
	SIGNIN(2, "SIGNIN"),
	REGISTRATION(3, "REGISTRATION"),
	ROLE_MANAGEMENT(4, "ROLE_MANAGEMENT"),
	INVENTORY(5, "INVENTORY"),
	LISTING(6, "LISTING"),
	RETURNS_TEMPLATE(7, "RETURNS_TEMPLATE"),
	SHIPPING_TEMPLATE(8, "SHIPPING_TEMPLATE"),
	ORDER_MANAGEMENT(9, "ORDER_MANAGEMENT"),
	MERCHANT_REPORTS(10, "MERCHANT_REPORTS"),
	SHIPPING(11, "SHIPPING"),
	TRACKING(12, "TRACKING");
	
	
	private int id;
	private String name;
	
	VTErrorDomainEnum(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
