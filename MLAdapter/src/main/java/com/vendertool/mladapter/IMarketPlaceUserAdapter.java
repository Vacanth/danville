package com.vendertool.mladapter;

import com.vendertool.sharedtypes.rnr.GetUserTokenRequest;
import com.vendertool.sharedtypes.rnr.GetUserTokenResponse;

public interface IMarketPlaceUserAdapter {

	public GetUserTokenResponse getUserToken( GetUserTokenRequest request);
}