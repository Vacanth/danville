package com.vendertool.mladapter;

import com.vendertool.mladapter.factory.IBaseMercadolibreOperationAdapter;
import com.vendertool.mladapter.factory.MercadolibreAdapterFactory;
import com.vendertool.sharedtypes.rnr.GetUserTokenRequest;
import com.vendertool.sharedtypes.rnr.GetUserTokenResponse;

public class MarketPlaceUserAdapter implements IMarketPlaceUserAdapter{

	public GetUserTokenResponse getUserToken(GetUserTokenRequest request) {
		IBaseMercadolibreOperationAdapter adapter = MercadolibreAdapterFactory
				.getInstance().getOperationAdapter(request);
		return (GetUserTokenResponse) adapter.execute(request);
	}
}