package com.vendertool.batch.product.validate;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.vendertool.batch.VenderBatchHelper;
import com.vendertool.batch.VenderBatchStatus;
import com.vendertool.dal.batchworklog.BatchWorkLog;
import com.vendertool.dal.batchworklog.BatchWorkLogDaoImpl;

@Component("productValidateReader")
public class ProductValidateFeedReader implements ItemReader<BatchWorkLog> {
	private Iterator<BatchWorkLog> iterator;
	@BeforeStep
	public void setExecution(StepExecution se) {
		JobParameters jobParams = se.getJobParameters();
		long batchId = VenderBatchHelper.getInstance().getBatchID(jobParams);
		List<BatchWorkLog> batchWorkLogList = BatchWorkLogDaoImpl.getInstance().findByBatchJobIdAndStatus(batchId,(byte)VenderBatchStatus.RECORD_LOADED.getValue());
		if(batchWorkLogList != null){
			iterator = batchWorkLogList.iterator();
		}
	}
	@Override
	public BatchWorkLog read() throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {
			
		if(iterator == null){
			return null;
		}
		
		if(iterator.hasNext()){
			return iterator.next();
		}
		return null;
	}
}