package com.vendertool.batch.product.validate;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.vendertool.batch.BatchListingHelper;
import com.vendertool.batch.VenderBatchHelper;
import com.vendertool.batch.VenderBatchStatus;
import com.vendertool.batch.listing.ProductBean;
import com.vendertool.common.user.UserUtils;
import com.vendertool.dal.batchworklog.BatchWorkLog;
import com.vendertool.dal.batchworklog.BatchWorkLogDaoImpl;
import com.vendertool.emailapp.VenderToolEmailService;
import com.vendertool.mladapter.factory.IBaseMercadolibreOperationAdapter;
import com.vendertool.mladapter.factory.MercadolibreAdapterFactory;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.rnr.VerifyListingRequest;
import com.vendertool.sharedtypes.rnr.VerifyListingResponse;

@Component("productValidateWriter")
public class ProductValidateFeedWriter implements ItemWriter<List<ProductBean>> {

	Map<String, String> jobParams;
	private static Gson gson = new Gson();
	private StepExecution se;

	@BeforeStep
	public void setExecution(StepExecution se) {
		this.se = se;
	}

	@Override
	public void write(List<? extends List<ProductBean>> items) throws Exception {

		if (items == null) {
			return;
		}
		String token = null;
		Listing listing = null;
		for (List<ProductBean> beans : items) {
			if (beans == null) {
				continue;
			}

			for (ProductBean productBean : beans) {
				if (token == null) {
					token = UserUtils.getInstance().getUserAccessToken(
							productBean.getUserAccountId());
					break;
				}
			}
			listing = BatchListingHelper.getInstance().adaptToListing(
					beans, se.getStartTime());
			if (listing == null) {
				continue;
			}

			VerifyListingRequest req = new VerifyListingRequest();
			req.setUserAccessToken(token);
			req.setListing(listing);
			IBaseMercadolibreOperationAdapter adapter = MercadolibreAdapterFactory
					.getInstance().getOperationAdapter(req);
			VerifyListingResponse response = (VerifyListingResponse) adapter
					.execute(req);
			gson.toJson(response);

			updateStatus(beans,
					(byte) VenderBatchStatus.RECORD_VALIDATION_SUCESS
							.getValue());

		}
	}

	// Update work log
	private void updateStatus(List<ProductBean> beans, byte value) {
		if (beans == null) {
			return;
		}
		for (ProductBean proBean : beans) {
			if (proBean == null) {
				continue;
			}
			BatchWorkLogDaoImpl.getInstance().updateStatusByWorkLogID(
					proBean.getRefId(), value);
		}
	}
}