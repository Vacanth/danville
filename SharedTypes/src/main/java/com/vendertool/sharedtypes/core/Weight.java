package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Weight {
	
	@XmlEnum
	public enum WeightUnitEnum {
		GRAMS,KGS,OUNCES,LBS;
	}
	
	private double value;
	private WeightUnitEnum weightUnit;
	
	public Weight() {
		this(0);
	}
	
	public Weight(double value) {
		setValue(value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public WeightUnitEnum getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(WeightUnitEnum weightUnit) {
		this.weightUnit = weightUnit;
	}
	
}
