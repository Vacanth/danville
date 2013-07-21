package com.vendertool.mladapter.factory;

import java.util.List;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;
import com.vendertool.mladapter.add.Item;
import com.vendertool.mladapter.factory.MercadolibreCommunicatorVO.MethodEnum;
import com.vendertool.sharedtypes.core.Classification;
import com.vendertool.sharedtypes.core.Classification.ClassificationTypeEnum;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.core.Listing.ListingFormatEnum;
import com.vendertool.sharedtypes.core.PaymentMethod;
import com.vendertool.sharedtypes.core.PaymentMethod.PaymentTypeEnum;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.VerifyListingRequest;
import com.vendertool.sharedtypes.rnr.VerifyListingResponse;

public class MercadolibreVerifyListingAdapter implements
IBaseMercadolibreOperationAdapter {

	private static String VERIFY_LISTING_URL = "https://api.mercadolibre.com/items/validate?access_token=";
	private static MercadolibreVerifyListingAdapter uniqInstance;

	private MercadolibreVerifyListingAdapter() {
	}

	public static synchronized MercadolibreVerifyListingAdapter getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new MercadolibreVerifyListingAdapter();
		}
		return uniqInstance;
	}

	public BaseResponse execute(BaseRequest request) {
		VerifyListingRequest listingRequest = (VerifyListingRequest) request;
//		User
		Item item = adaptToRequest(listingRequest);
		//Call Verify
		MercadolibreCommunicatorVO communicatorVO = new MercadolibreCommunicatorVO();
		communicatorVO.setRequestObject(item);
		communicatorVO.setMethodEnum(MethodEnum.POST);
		communicatorVO.setTargetURL(VERIFY_LISTING_URL+listingRequest.getUserAccessToken());
		MercadolibreCommunicator communicator = MercadolibreCommunicator.getInstance();
		ClientResponse response = communicator.call(communicatorVO);

		//TODO return error if the sta
		if (response.getStatus() != 204) {
			throw new RuntimeException("Failed Listing validation : HTTP error code : "
					+ response.getStatus());
		}
		VerifyListingResponse vlResponse = new VerifyListingResponse();
		
		return vlResponse;
	}

	private Item adaptToRequest(VerifyListingRequest listingRequest) {
		if (listingRequest == null) {
			return null;
		}
		Listing listing = listingRequest.getListing();

		if (listing == null) {
			return null;
		}
		Item item = null;

		Product product = listing.getProduct();

		if (isProductIDAvailalbe(product)) {
			item = prepareItemFromInventory(product.getProductId());// TODO
		} else {
			item = getFromRequest(listing);
		}
		return item;
	}

	private Item getFromRequest(Listing listing) {
		Product product = listing.getProduct();

		if (product == null) {
			return null;
		}
		// TODO validate the request?
		Item item = new Item();
		item.setTitle(product.getTitle());
		List<Classification> classifications = listing.getClassifications();

		// Set Category
		if (classifications != null) {
			for (Classification classification : classifications) {
				if (classification == null) {
					continue;
				}
				ClassificationTypeEnum classificationType = classification
						.getClassificationType();
				if (ClassificationTypeEnum.CATEGORY == classificationType) {
					item.setCategory_id(classification.getClassifierId());
				}
			}
		}

		// Set Price
		if (listing.getPrice() != null) {
			item.setPrice(listing.getPrice().getValue());
			item.setCurrency_id("ARS");// TODO remove this hardcoding
		}
		item.setDescription(product.getDescription());
		ListingFormatEnum listingFormate = listing.getListingFormat();
		if (listingFormate != null) {
			String buyingMode = "buy_it_now";
			if (listingFormate == ListingFormatEnum.AD) {
				buyingMode = "classified";
			} else if (ListingFormatEnum.AUCTION == listingFormate) {
				buyingMode = "auction";
			}
			item.setBuying_mode(buyingMode);
		}

		item.setCondition(listing.getCondition());
		item.setListing_type_id(listing.getListingId());// TODO listing
		item.setAvailable_quantity(listing.getQuantity());
		// Set Payment menthods.
		List<PaymentMethod> paymentMethods = listing.getPaymentMethods();
		if (paymentMethods != null) {
			for (PaymentMethod paymentMethod : paymentMethods) {
				if (paymentMethod == null) {
					continue;
				}
				PaymentTypeEnum paymentMethodType = paymentMethod.getMethod();
				if (PaymentTypeEnum.MERCADO_PAGO == paymentMethodType) {
					item.setAccepts_mercadopago(true);
				}
			}
		}
		return item;
	}

	private Item prepareItemFromInventory(String productId) {
		Item item = new Item();
		// TODO make DB call and prepare this.
		return item;
	}

	private boolean isProductIDAvailalbe(Product product) {
		return product != null && product.getProductId() != null
				&& product.getProductId().length() > 0;
	}
}
