package com.vendertool.dal.batchjob;

import java.util.List;


public interface BatchJobDao {

	void insert (BatchJob batchJob);

	void update(BatchJob batchJob);

	void delete(BatchJob batchJob);

	List<BatchJob> findByBatchJobId(long batchJobId);
	
}
