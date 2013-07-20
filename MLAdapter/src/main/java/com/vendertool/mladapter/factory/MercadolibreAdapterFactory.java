package com.vendertool.mladapter.factory;

import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.GetListingRequest;
import com.vendertool.sharedtypes.rnr.GetUserTokenRequest;

public class MercadolibreAdapterFactory {

	private static MercadolibreAdapterFactory uniqInstance;

	private MercadolibreAdapterFactory() {
	}

	public static synchronized MercadolibreAdapterFactory getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new MercadolibreAdapterFactory();
		}
		return uniqInstance;
	}

	public IBaseMercadolibreOperationAdapter getOperationAdapter(
			BaseRequest request) {
		if (request instanceof AddListingRequest) {
			return MercadolibreListingAdapter.getInstance();
		}else if(request instanceof GetListingRequest){
			return MercadolibreGetListingAdapter.getInstance();
		}else if(request instanceof GetUserTokenRequest){
			return MercadolibreUserAdapter.getInstance();
		}
		return null;
	}
}