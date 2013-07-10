package com.vendertool.mladapter.factory;

import javax.ws.rs.core.MediaType;

public class MercadolibreCommunicatorVO {

	public enum MethodEnum {
		GET, POST, PUT, DELETE;
	}

	private String targetURL;
	private MediaType mediaType;
	private MethodEnum methodEnum;
	private Object requestObject;//It can be any object, this communicator don't need to understand any.

	public Object getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(Object requestObject) {
		this.requestObject = requestObject;
	}

	public String getTargetURL() {
		return targetURL;
	}

	public void setTargetURL(String targetURL) {
		this.targetURL = targetURL;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public MethodEnum getMethodEnum() {
		return methodEnum;
	}

	public void setMethodEnum(MethodEnum methodEnum) {
		this.methodEnum = methodEnum;
	}
}