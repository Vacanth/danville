package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dimension {
	
	@XmlEnum
	public enum DimensionUnitEnum {
		MM,CMS,INCHES,FEET;
	}
	
	private int length;
	private int width;
	private int height;
	private DimensionUnitEnum dimensionUnit;
	
	public Dimension() {
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public DimensionUnitEnum getDimensionUnit() {
		return dimensionUnit;
	}
	public void setDimensionUnit(DimensionUnitEnum dimensionUnit) {
		this.dimensionUnit = dimensionUnit;
	}
}
