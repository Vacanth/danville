package com.vendertool.batch;

import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;

import com.vendertool.batch.mappers.BatchConstants;

public class VenderBatchHelper {

	private static VenderBatchHelper s_self = new VenderBatchHelper();

	private VenderBatchHelper() {
		
	}

	public static VenderBatchHelper getInstance() {
		if(s_self == null){
			s_self = new VenderBatchHelper();
		}
		return s_self;
	}

	public long getBatchID(JobParameters jobParams) {
		long batchJobId = 0;
		if (jobParams == null) {
			return batchJobId;
		}
		Map<String, JobParameter> paramMap = jobParams.getParameters();
		JobParameter jobParam = paramMap.get(BatchConstants.BATCH_JOB_ID);
		if (jobParam != null) {
			batchJobId = Long.valueOf(jobParam.getValue() + "");
		}
		return batchJobId;
	}
}
