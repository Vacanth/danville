package com.vendertool.dal.batchworklog;

import java.util.List;


public interface BatchWorkLogDao {

	void insert (BatchWorkLog batchWorkLog);

	void update(BatchWorkLog batchWorkLog);

	void delete(BatchWorkLog batchWorkLog);

	List<BatchWorkLog> findByBatchJobId(long batchId);
	List<BatchWorkLog> findByBatchJobIdAndStatus(long batchId,Byte status);
	List<BatchWorkLog> findByBatchWorkLogId(long batchWorkLogId);
	
}
