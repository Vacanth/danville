package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Classification {
	
	@XmlEnum
	public enum ClassificationTypeEnum {
		CATEGORY,PRODUCT,KEYWORD,TITLE;
	}
	
	private ClassificationTypeEnum classificationType;
	private String classifierId;
	
	public Classification(){}

	public ClassificationTypeEnum getClassificationType() {
		return classificationType;
	}

	public void setClassificationType(ClassificationTypeEnum classificationType) {
		this.classificationType = classificationType;
	}

	public String getClassifierId() {
		return classifierId;
	}

	public void setClassifierId(String classifierId) {
		this.classifierId = classifierId;
	}
}
