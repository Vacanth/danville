package com.vendertool.mladapter.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.vendertool.mladapter.factory.MercadolibreCommunicatorVO.MethodEnum;
import com.vendertool.mladapter.user.MLUserTokenRequest;
import com.vendertool.mladapter.user.MLUserTokenResponse;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetUserTokenRequest;
import com.vendertool.sharedtypes.rnr.GetUserTokenResponse;

public class MercadolibreUserAdapter implements
		IBaseMercadolibreOperationAdapter {

	private static String OAUTH_TOKEN_URL = "https://api.mercadolibre.com/oauth/token";//TODO : we will make it dynamic
	private static MercadolibreUserAdapter uniqInstance;

	private MercadolibreUserAdapter() {
	}

	public static synchronized MercadolibreUserAdapter getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new MercadolibreUserAdapter();
		}
		return uniqInstance;
	}

	public BaseResponse execute(BaseRequest request) {
		GetUserTokenRequest tokenRequest = (GetUserTokenRequest) request;
		MercadolibreCommunicatorVO communicatorVO = new MercadolibreCommunicatorVO();
		communicatorVO.setMethodEnum(MethodEnum.POST);
		communicatorVO.setMediaType(MediaType.APPLICATION_FORM_URLENCODED_TYPE);//application/octet-stream
		communicatorVO.setTargetURL(OAUTH_TOKEN_URL);

		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.add("client_id",tokenRequest.getClientId());
		formData.add("client_secret", tokenRequest.getClientSecret());
		formData.add("grant_type", "client_credentials");
		communicatorVO.setFormData(formData);
		
		MercadolibreCommunicator communicator = MercadolibreCommunicator
				.getInstance();
		ClientResponse response = communicator.call(communicatorVO);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		
		String jsonResponse = response.getEntity(String.class);
		if(jsonResponse != null){
			Gson gson = new Gson();
			MLUserTokenResponse mlResponse = gson.fromJson(jsonResponse, MLUserTokenResponse.class);
			if(mlResponse != null){
				return adaptToResponse(mlResponse);
			}
		}
		
		return null;
	}

	private GetUserTokenResponse adaptToResponse(MLUserTokenResponse mlResponse) {
		GetUserTokenResponse resp = new GetUserTokenResponse();
		resp.setAccessToken(mlResponse.getAccess_token());
		resp.setRefreshToken(mlResponse.getRefresh_token());
		resp.setTokenType(mlResponse.getToken_type());
		resp.setExpiryDate(getDate(mlResponse.getExpires_in()));
		resp.setScope(getScopeList(mlResponse.getScope()));
		return resp;
	}

	private List<String> getScopeList(String scope) {
		List<String> scopeList = new ArrayList<String>();
		if(scope != null){
			StringTokenizer str = new StringTokenizer(scope, " ");
			while(str.hasMoreTokens()){
				scopeList.add(str.nextToken());
			}
		}
		return scopeList;
	}

	private Date getDate(String expires_in) {
		int expInMinutes = Integer.valueOf(expires_in);
		Calendar cal = Calendar.getInstance(); // creates calendar
	    cal.setTime(new Date()); // sets calendar time/date
	    cal.add(Calendar.MINUTE, expInMinutes); // adds one hour
	    return cal.getTime(); 
	}

	private MLUserTokenRequest adaptToMLRequest(GetUserTokenRequest tokenRequest) {
		MLUserTokenRequest request = new MLUserTokenRequest();
		request.setClient_id(tokenRequest.getClientId());
		request.setClient_secret(tokenRequest.getClientSecret());
		request.setGrant_type("client_credentials");
		return request;
	}
	
	public static void main(String args[]){
		GetUserTokenRequest req = new GetUserTokenRequest();
		req.setClientId("6965385537109061");
		req.setClientSecret("0BiZVJ7uMa5bosimefCGOHFSyFlpzJua");
		GetUserTokenResponse response = (GetUserTokenResponse) getInstance().execute(req);
		System.out.println(response.getAccessToken());
	}
}