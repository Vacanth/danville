package com.vendertool.dal;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.dal.hibernate.HibernateUtil;
import com.vendertool.dal.productspecification.ProductSpecification;

public class ProductSpecificationDAOTests {

	public static void main(String args[]){
		savePlayer(null);
	}
	 @SuppressWarnings("unused")
	private static void savePlayer(ProductSpecification player) {/*
		 
		 ProductSpecification productSpe = new ProductSpecification();
		 productSpe.setCreateDate(new Date());
		 productSpe.setRefId(12344);
		 productSpe.setWidth(new BigDecimal(12));
		 productSpe.setHeight(new BigDecimal(12));
		 productSpe.setHeight(new BigDecimal(12));
		 productSpe.setWeightUnit( (byte)1);
		 productSpe.setLastModifiedDate(new Date());
		 productSpe.setProductSpecificationId(34566);
		    Session session = null;
		    Transaction tx = null;
		    try {
		      session = HibernateUtil.getSession();
		      tx = session.beginTransaction();
		      session.save(productSpe);
		      tx.commit();
		    } catch (Exception e) {
		      tx.rollback();
		    } finally {
		      if (session != null) {
		        session.close();
		      }
		    }
		  */}
}
