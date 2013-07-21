package com.vendertool.batch.product.insert;

import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.vendertool.batch.BatchListingHelper;
import com.vendertool.batch.VenderBatchStatus;
import com.vendertool.batch.listing.ProductBean;
import com.vendertool.common.user.UserUtils;
import com.vendertool.dal.batchworklog.BatchWorkLog;
import com.vendertool.dal.batchworklog.BatchWorkLogDaoImpl;
import com.vendertool.mladapter.factory.IBaseMercadolibreOperationAdapter;
import com.vendertool.mladapter.factory.MercadolibreAdapterFactory;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.AddListingResponse;

@Component("productInsertWriter")
public class ProductInsertFeedWriter implements ItemWriter<BatchWorkLog> {
	private static Gson gson = new Gson();
	private StepExecution se;

	@BeforeStep
	public void setExecution(StepExecution se) {
		this.se = se;
	}
	@Override
	public void write(List<? extends BatchWorkLog> items) throws Exception {


		if (items == null) {
			return;
		}

		for (BatchWorkLog bean : items) {
			if (bean == null) {
				continue;
			}
			byte[] request = bean.getRequest();
			String requestString = new String(request);
			ProductBean productBean = gson.fromJson(requestString,
					ProductBean.class);
			String token = UserUtils.getInstance().getUserAccessToken(
					productBean.getUserAccountId());
			AddListingRequest req = new AddListingRequest();
			req.setUserAccessToken(token);

			Listing listing = BatchListingHelper.getInstance().adaptToListing(
					productBean, se.getStartTime());
			req.setListing(listing);
			IBaseMercadolibreOperationAdapter adapter = MercadolibreAdapterFactory
					.getInstance().getOperationAdapter(req);
			AddListingResponse response = (AddListingResponse)adapter.execute(req);
			gson.toJson(response);
			
			//Check if there are any errors in the response. Update the response in the work log table.
			bean.setStatus((byte)VenderBatchStatus.RECORD_OPERATION_SUCESS.getValue());
			//TODO update the response in bean, that needs to be generated in output file.
			BatchWorkLogDaoImpl.getInstance().update(bean);
		}
	
	}
}