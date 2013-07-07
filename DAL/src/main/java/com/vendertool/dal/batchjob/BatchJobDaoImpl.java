/**
 * 
 */
package com.vendertool.dal.batchjob;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.dal.BaseDaoImpl;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class BatchJobDaoImpl extends BaseDaoImpl implements BatchJobDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (BatchJob batchJob) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(batchJob);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(BatchJob batchJob) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(batchJob);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(BatchJob batchJob) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(batchJob);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<BatchJob> findByBatchJobId(long batchJobId) {
		// TODO Auto-generated method stub
		String sql = "select * from batch_job where batch_job_id = :batch_job_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("batch_job_id", batchJobId);
		query.addEntity(BatchJob.class);
		List<BatchJob> results = query.list();
		return  results;
	}

}
