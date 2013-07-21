package com.vendertool.batch.product.read;

import java.util.List;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.vendertool.batch.VenderBatchHelper;
import com.vendertool.batch.VenderBatchStatus;
import com.vendertool.batch.listing.ProductBean;
import com.vendertool.dal.batchworklog.BatchWorkLog;
import com.vendertool.dal.batchworklog.BatchWorkLogDaoImpl;

@Component("productInputWriter")
public class ProductInputFeedWriter implements ItemWriter<ProductBean> {
	
	private long batchId;
	private static Gson gson = new Gson();

	@BeforeStep
	public void setExecution(StepExecution se) {
		JobParameters jobParams = se.getJobParameters();
		batchId = VenderBatchHelper.getInstance().getBatchID(jobParams);
	}

	@Override
	public void write(List<? extends ProductBean> items) throws Exception {
		
		if(items == null){
			return;
		}
		for(ProductBean bean : items){
			if(bean == null){
				continue;
			}
			String request = gson.toJson(bean);
			BatchWorkLog workLog = new BatchWorkLog();
			workLog.setAccountId(1l);
			workLog.setApiAction("PRODUCT");
//			workLog.setId(id);
			workLog.setStatus((byte)VenderBatchStatus.RECORD_LOADED.getValue());
			workLog.setRequest(request.getBytes());
			workLog.setRecordId(batchId);
			workLog.setBatchId(batchId);
			BatchWorkLogDaoImpl.getInstance().insert(workLog);
		}
	}
}