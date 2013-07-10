package com.vendertool.mladapter.factory;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sun.jersey.api.client.ClientResponse;
import com.vendertool.mladapter.add.Item;
import com.vendertool.mladapter.factory.MercadolibreCommunicatorVO.MethodEnum;
import com.vendertool.sharedtypes.core.Amount;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetListingRequest;
import com.vendertool.sharedtypes.rnr.GetListingResponse;

public class MercadolibreGetListingAdapter implements
		IBaseMercadolibreOperationAdapter {

	private static String GET_LISTING_URL = "https://api.mercadolibre.com/items/";
	private static MercadolibreGetListingAdapter uniqInstance;

	private MercadolibreGetListingAdapter() {
	}

	public static synchronized MercadolibreGetListingAdapter getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new MercadolibreGetListingAdapter();
		}
		return uniqInstance;
	}

	public BaseResponse execute(BaseRequest request) {
		GetListingRequest itemId = (GetListingRequest) request;

		MercadolibreCommunicatorVO communicatorVO = new MercadolibreCommunicatorVO();
		communicatorVO.setMethodEnum(MethodEnum.GET);
		communicatorVO.setMediaType(MediaType.APPLICATION_JSON_TYPE);
		communicatorVO.setTargetURL(GET_LISTING_URL + itemId.getListingId());
		MercadolibreCommunicator communicator = MercadolibreCommunicator
				.getInstance();
		ClientResponse response = communicator.call(communicatorVO);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = (String) response.getEntity(String.class);
		Item responseItem = readItem(output);

		GetListingResponse getListingResponse = adaptToGetListingResponse(responseItem);
		return getListingResponse;
	}

	private GetListingResponse adaptToGetListingResponse(Item responseItem) {
		if (responseItem == null) {
			return null;
		}
		GetListingResponse response = new GetListingResponse();

		Listing listing = new Listing();

		listing.setCondition(responseItem.getCondition());
		listing.setPrice(new Amount());
		listing.setQuantity(responseItem.getAvailable_quantity().intValue());
		Product product = new Product();
		// product.setDescription(responseItem.getDescriptions());
		product.setTitle(responseItem.getTitle());
		listing.setProduct(product);
		response.setListing(listing);
		return response;
	}

	private Item readItem(String output) {
		Item response = null;
		Gson gson = new Gson();
		response = gson.fromJson(output, Item.class);
		return response;
	}
}