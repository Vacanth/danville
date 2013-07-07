package com.vendertool.dal;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vendertool.dal.productspecification.ProductSpecification;
import com.vendertool.dal.productspecification.ProductSpecificationDao;


public class DalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		@SuppressWarnings("resource")
		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("BeanLocations.xml");
		
		try{
			System.out.println("Account dal Test Began !!!");
			ProductSpecificationDao accountDao = (ProductSpecificationDao) appContext.getBean("productSpecificationDAO"); 
			 ProductSpecification productSpe = new ProductSpecification();
			 productSpe.setCreateDate(new Date());
			 productSpe.setProductId(123);
			 productSpe.setWidth(new BigDecimal(12));
			 productSpe.setHeight(new BigDecimal(12));
			 productSpe.setHeight(new BigDecimal(12));
			 productSpe.setWeightUnit( (byte)1);
			 productSpe.setLastModifiedDate(new Date());
			 productSpe.setProductSpecificationId(34566);
			 accountDao.insert(productSpe);
		} finally {
		}
	}
}