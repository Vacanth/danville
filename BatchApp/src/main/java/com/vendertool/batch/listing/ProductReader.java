package com.vendertool.batch.listing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.vendertool.batch.mappers.BatchConstants;
import com.vendertool.batch.mappers.CSVMapHelper;
import com.vendertool.dal.batchjob.BatchJob;
import com.vendertool.dal.batchjob.BatchJobDaoImpl;

@Component("productreader")
public class ProductReader implements ItemReader<ProductBean> {
	private List<ProductBean> list;
	private Iterator<ProductBean> productIterator;
	private long userId;

	@BeforeStep
	public void setExecution(StepExecution se) {
		JobParameters jobParams = se.getJobParameters();
		Map<String, JobParameter> paramMap = jobParams.getParameters();
		JobParameter jobParam = paramMap.get(BatchConstants.BATCH_JOB_ID);
		List<BatchJob> batchJobList = null;
		if (jobParam != null) {
			long batchJobId = Long.valueOf(jobParam.getValue()+"");
			if (batchJobId > 0) {
				batchJobList = BatchJobDaoImpl.getInstance().findByBatchJobId(
						batchJobId);
			}
		}
		if (batchJobList != null && batchJobList.size() > 0) {
//		if(true){
			try {
				list = CSVMapHelper.getInstance().getProductBeans(batchJobList.get(0).getReqLocation());
				userId = batchJobList.get(0).getAccountId(); 
//				list = CSVMapHelper.getInstance().getProductBeans(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list != null) {
				productIterator = list.iterator();
			}
		}
	}

	@Override
	public ProductBean read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if (productIterator == null) {
			return null;
		}
		if (productIterator.hasNext()) {
			ProductBean product = productIterator.next();
			product.setUserAccountId(userId);
			return product;
		}
		return null;
	}
}
