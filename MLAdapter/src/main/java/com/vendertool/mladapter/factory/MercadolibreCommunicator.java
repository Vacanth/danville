package com.vendertool.mladapter.factory;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.vendertool.mladapter.factory.MercadolibreCommunicatorVO.MethodEnum;
import com.vendertool.mladapter.user.MLUserTokenResponse;

public class MercadolibreCommunicator {
	private static MercadolibreCommunicator uniqInstance;

	private MercadolibreCommunicator() {
	}

	public static synchronized MercadolibreCommunicator getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new MercadolibreCommunicator();
		}
		return uniqInstance;
	}
	
	public ClientResponse call(MercadolibreCommunicatorVO communicatorVO){
		WebResource resource = Client.create().resource(
				communicatorVO.getTargetURL());
		MediaType mediaType[] = new MediaType[1];
		mediaType[0] = communicatorVO.getMediaType();
		ClientResponse response = null;
		if (communicatorVO.getMethodEnum() == MethodEnum.GET) {
			response = (ClientResponse) resource.accept(mediaType).get(
					ClientResponse.class);
		} else if (communicatorVO.getMethodEnum() == MethodEnum.POST) {
			if(mediaType[0] == MediaType.APPLICATION_FORM_URLENCODED_TYPE && communicatorVO.getFormData() != null){
				resource.accept(MediaType.APPLICATION_JSON_TYPE);
				response = resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, communicatorVO.getFormData());;
			}else{
				Gson gson = new Gson();
				
				response = resource.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class,
						gson.toJson(communicatorVO.getRequestObject()));	
			}
			
		} else if (communicatorVO.getMethodEnum() == MethodEnum.DELETE) {
			response = resource.delete(ClientResponse.class,
					communicatorVO.getRequestObject());
		} else if (communicatorVO.getMethodEnum() == MethodEnum.PUT) {
			response = resource.put(ClientResponse.class,
					communicatorVO.getRequestObject());
		}

		return response;
	}
}