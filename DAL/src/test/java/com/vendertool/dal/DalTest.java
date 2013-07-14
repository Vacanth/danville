package com.vendertool.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vendertool.dal.batchjob.BatchJob;
import com.vendertool.dal.batchjob.BatchJobDao;


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
		
		try{
			System.out.println("batch job  dal Test Began !!!");
			BatchJobDao batchJobDao = (BatchJobDao) appContext.getBean("batchJobDao"); 
			BatchJob batchJob = new BatchJob();
			batchJob=(BatchJob) batchJobDao.findByBatchJobId(1).get(0);
			System.out.println(batchJob.getFileName());
		} finally {
		}
	}
}