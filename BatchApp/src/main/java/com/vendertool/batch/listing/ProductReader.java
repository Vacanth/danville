package com.vendertool.batch.listing;

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

import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import com.vendertool.batch.mappers.BatchConstants;
import com.vendertool.batch.mappers.CSVMapHelper;
import com.vendertool.batch.mappers.CSVToBeanHelper;
import com.vendertool.dal.batchjob.BatchJob;
import com.vendertool.dal.batchjob.BatchJobDaoImpl;

@Component("productreader")
public class ProductReader implements ItemReader<ProductBean> {
	private StepExecution stepExe;
	private List<ProductBean> list;
	private Iterator<ProductBean> productIterator;

	@BeforeStep
	public void setExecution(StepExecution se) {
		stepExe = se;
		JobParameters jobParams = se.getJobParameters();
		Map<String, JobParameter> paramMap = jobParams.getParameters();
		JobParameter jobParam = paramMap.get(BatchConstants.BATCH_JOB_ID);
		List<BatchJob> batchJobList = null;
		if(jobParam != null){
			long batchJobId = (Long)jobParam.getValue();
			if(batchJobId > 0 ){
				batchJobList = BatchJobDaoImpl.getInstance().findByBatchJobId(batchJobId);
			}
		}
		if(true){
			HeaderColumnNameTranslateMappingStrategy<ProductBean> strategy = new HeaderColumnNameTranslateMappingStrategy<ProductBean>();
			strategy.setType(ProductBean.class);
			strategy.setColumnMapping(CSVMapHelper.getInstance()
					.getProductFeedMapper());
			CSVToBeanHelper<ProductBean> helper = new CSVToBeanHelper<ProductBean>();
			list = helper.getMappedBean(strategy, "C:\\AppDev\\Sample.csv");
			if(list != null){
				productIterator = list.iterator();
			}
		}
	}

	@Override
	public ProductBean read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if(productIterator == null){
			return null;
		}
		if(productIterator.hasNext()){
			ProductBean product = productIterator.next();
			return product;
		}
		return null;
	}
}