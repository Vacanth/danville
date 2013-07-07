package com.vendertool.mladapter;

import com.vendertool.mladapter.factory.IBaseMercadolibreOperationAdapter;
import com.vendertool.mladapter.factory.MercadolibreAdapterFactory;
import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.AddListingResponse;
import com.vendertool.sharedtypes.rnr.DuplicateListingResponse;
import com.vendertool.sharedtypes.rnr.EndListingResponse;
import com.vendertool.sharedtypes.rnr.GetListingRequest;
import com.vendertool.sharedtypes.rnr.GetListingResponse;
import com.vendertool.sharedtypes.rnr.UpdateListingRequest;
import com.vendertool.sharedtypes.rnr.UpdateListingResponse;
import com.vendertool.sharedtypes.rnr.VerifyListingRequest;
import com.vendertool.sharedtypes.rnr.VerifyListingResponse;

public class MarketListingAdapterImpl implements IMarketListingAdapter {

	public AddListingResponse addListing(AddListingRequest request) {
		IBaseMercadolibreOperationAdapter adapter = MercadolibreAdapterFactory
				.getInstance().getOperationAdapter(request);
		return (AddListingResponse) adapter.execute(request);
	}

	public GetListingResponse getListing(String marketListingId) {
		GetListingRequest request = new GetListingRequest();
		request.setListingId(marketListingId);
		IBaseMercadolibreOperationAdapter adapter = MercadolibreAdapterFactory
				.getInstance().getOperationAdapter(request);
		return (GetListingResponse) adapter.execute(request);
	}

	public EndListingResponse endListing(String listingId) {
		return null;
	}

	public UpdateListingResponse updateListing(UpdateListingRequest request) {
		return null;
	}

	public DuplicateListingResponse duplicateListing(String listingId) {
		return null;
	}

	public VerifyListingResponse verifyListing(VerifyListingRequest request) {
		return null;
	}
}
