package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum VTErrorSeverityEnum {
	
	INFO(1, "INFO"),
	WARNING(2, "WARNING"),	
	ERROR(3, "ERROR"),
	FATAL(4, "FATAL");
	
	private int id;
	private String name;
	
	VTErrorSeverityEnum(int id, String name){
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
