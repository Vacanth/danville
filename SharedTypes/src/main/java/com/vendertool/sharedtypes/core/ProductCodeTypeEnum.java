package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ProductCodeTypeEnum {
	ISBN(1, "ISBN"),
	UPC(2, "UPC"),
	MPN(3, "MPN");
	
	private int id;
	private String name;
	
	ProductCodeTypeEnum(){
		this(-1, "UNKNOWN");
	}
	
	ProductCodeTypeEnum(int id, String name){
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
