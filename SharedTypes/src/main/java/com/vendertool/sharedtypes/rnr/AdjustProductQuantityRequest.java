package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdjustProductQuantityRequest extends BaseRequest {
	private int quantity;
	private ArithmeticOpCodeEnum operation;
	
	public AdjustProductQuantityRequest(){}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArithmeticOpCodeEnum getOperation() {
		return operation;
	}

	public void setOperation(ArithmeticOpCodeEnum operation) {
		this.operation = operation;
	}
}
