package com.vendertool.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vendertool.dal.accountmarketplace.AccountMarketplace;
import com.vendertool.dal.batchworklog.BatchWorkLog;
import com.vendertool.dal.batchworklog.BatchWorkLogDao;


public class DalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		@SuppressWarnings("resource")
		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("BeanLocations.xml");
		
		/*try{
			System.out.println("Account dal Test Began !!!");
			ProductSpecificationDao productSpecificationDao = (ProductSpecificationDao) appContext.getBean("productSpecificationDAO"); 
			 ProductSpecification productSpe = new ProductSpecification();
			 productSpe.setCreateDate(new Date());
			 productSpe.setProductId(123);
			 productSpe.setWidth(new BigDecimal(12));
			 productSpe.setHeight(new BigDecimal(12));
			 productSpe.setHeight(new BigDecimal(12));
			 productSpe.setWeightUnit( (byte)1);
			 productSpe.setLastModifiedDate(new Date());
			 productSpe.setProductSpecificationId(34568);
			 productSpecificationDao.insert(productSpe);
		} finally {
		}*/
		
		/*try{
			System.out.println("batch job  dal Test Began !!!");
			AccountMarketplaceDao accountMarketplaceDao = (AccountMarketplaceDao) appContext.getBean("accountMarketplaceDao"); 
			AccountMarketplace accountMarketplace = new AccountMarketplace();
			accountMarketplace.setAccountId((long) 1);
			accountMarketplace=(AccountMarketplace) accountMarketplaceDao.findByAccountId(accountMarketplace).get(0);
			System.out.println(accountMarketplace.getMpClientId());
		} finally {
		}*/
		
		try{
			System.out.println("batch work log dal Test Began !!!");
			BatchWorkLogDao batchWorkLogDao = (BatchWorkLogDao) appContext.getBean("batchWorkLogDao"); 
			BatchWorkLog batchWorkLog = new BatchWorkLog();
			batchWorkLog.setBatchId(102);
			batchWorkLog.setBatchWorkLogId(102);
			batchWorkLog.setFileId(101);
			batchWorkLogDao.insert(batchWorkLog);
			batchWorkLog=(BatchWorkLog) batchWorkLogDao.findByBatchJobId(1).get(0);
			System.out.println(batchWorkLog.getBatchWorkLogId());
		} finally {
		}
	}
}