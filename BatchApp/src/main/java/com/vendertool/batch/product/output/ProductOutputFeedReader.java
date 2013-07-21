package com.vendertool.batch.product.output;

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
import com.vendertool.dal.batchworklog.BatchWorkLog;
import com.vendertool.dal.batchworklog.BatchWorkLogDaoImpl;

@Component("outputDBReader")
public class ProductOutputFeedReader implements ItemReader<List<BatchWorkLog>> {
	private List<BatchWorkLog> list;
	private StepExecution se;
	@BeforeStep
	public void setExecution(StepExecution se) {
		this.se = se;
		JobParameters jobParams = se.getJobParameters();
		long batchId = VenderBatchHelper.getInstance().getBatchID(jobParams);
		List<BatchWorkLog> batchWorkLogList = BatchWorkLogDaoImpl.getInstance().findByBatchJobId(batchId);
		if(batchWorkLogList != null){
			list = batchWorkLogList;
		}
	}
	@Override
	public List<BatchWorkLog> read() throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {
		if(!(se.getCommitCount()>0)){
			return list;	
		}
		return null;
	}
}