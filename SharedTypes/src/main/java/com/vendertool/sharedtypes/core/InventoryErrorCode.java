package com.vendertool.sharedtypes.core;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InventoryErrorCode extends VTErrorCode {
	private static Set<String> ALL_INVENTORY_ERROR_CODES = new HashSet<String>();
	
	public InventoryErrorCode(){super("UNKNOWN");}
	
	public InventoryErrorCode(String errorCode) {
		super(errorCode);
	}

	public Set<String> getCachedErrorCodes() {
		return ALL_INVENTORY_ERROR_CODES;
	}
	
	public static VTErrorCode INSUFFICIENT_PRODUCT_INFORMATION = new InventoryErrorCode(
			"INSUFFICIENT_PRODUCT_INFORMATION");
	public static VTErrorCode INVALID_PRODUCT = new InventoryErrorCode(
			"INVALID_PRODUCT");
	public static VTErrorCode PRODUCT_TITLE_MISSING = new InventoryErrorCode(
			"PRODUCT_TITLE_MISSING");
}
