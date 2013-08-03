package com.vendertool.batch.product.validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.vendertool.batch.VenderBatchHelper;
import com.vendertool.batch.VenderBatchStatus;
import com.vendertool.batch.listing.ProductBean;
import com.vendertool.dal.batchworklog.BatchWorkLog;
import com.vendertool.dal.batchworklog.BatchWorkLogDaoImpl;

@Component("productValidateReader")
public class ProductValidateFeedReader implements ItemReader<List<ProductBean>> {
	private Iterator<String> iterator;
	private Map<String, List<ProductBean>> productsToList;
	private static Gson gson = new Gson();

	@BeforeStep
	public void setExecution(StepExecution se) {
		JobParameters jobParams = se.getJobParameters();
		long batchId = VenderBatchHelper.getInstance().getBatchID(jobParams);
		List<BatchWorkLog> batchWorkLogList = BatchWorkLogDaoImpl.getInstance()
				.findByBatchJobIdAndStatus(batchId,
						(byte) VenderBatchStatus.RECORD_LOADED.getValue());
		Iterator<BatchWorkLog> workLogIterator = null;
		if (batchWorkLogList != null) {
			workLogIterator = batchWorkLogList.iterator();
		}
		if (workLogIterator == null) {
			return;
		}
		while (workLogIterator.hasNext()) {
			BatchWorkLog workLog = workLogIterator.next();
			byte[] requestLog = workLog.getRequest();

			String requestString = new String(requestLog);
			ProductBean productBean = gson.fromJson(requestString,
					ProductBean.class);
			productBean.setRefId(workLog.getBatchWorkLogId());
			putSkuInMap(productBean);
		}
		Set<String> keySet = productsToList.keySet();
		if (keySet != null) {
			iterator = keySet.iterator();
		}
	}

	private void putSkuInMap(ProductBean productBean) {
		if (productBean == null) {
			return;
		}
		String sku = productBean.getSku();
		if (sku == null) {
			return;
		}

		if (productsToList == null) {
			productsToList = new HashMap<String, List<ProductBean>>();
		}

		List<ProductBean> beanList = productsToList.get(sku);
		if (beanList == null) {
			beanList = new ArrayList<ProductBean>();
			beanList.add(productBean);
			productsToList.put(sku, beanList);
		} else {
			beanList.add(productBean);
		}
	}

	@Override
	public List<ProductBean> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		if (iterator == null) {
			return null;
		}
		List<ProductBean> productList = null;
		if (iterator.hasNext()) {
			String sku = iterator.next();
			productList = productsToList.get(sku);
		}
		return productList;
	}
}