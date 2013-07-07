package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethod {
	
	@XmlEnum
	public enum PaymentTypeEnum {
		MERCADO_PAGO, CREDIT_CARD_VISA, CREDIT_CARD_MASTER, PAYPAL;
	}
	
	
	private PaymentTypeEnum method;
	private String paymentId;
	
	public PaymentMethod(){}
	
	public PaymentTypeEnum getMethod() {
		return method;
	}

	public void setMethod(PaymentTypeEnum method) {
		this.method = method;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
}
