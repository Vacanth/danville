package com.vendertool.mladapter.factory;

import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public interface IBaseMercadolibreOperationAdapter {

	public BaseResponse execute(BaseRequest request);
}