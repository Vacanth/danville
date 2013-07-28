package com.vendertool.metadata;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	static EntityManagerFactory emf = null;
	static EntityManager manager = null;

	static {
		emf = Persistence.createEntityManagerFactory("cassandra_pu");
		manager = emf.createEntityManager();
		System.setProperty("cassandra.join_ring", "false");
	}
	
	public static void main(String[] args) {
		//insert();
		findByCategory("MLB27530");
//		update();
		findByCategory("MLB27530");
//		delete();
		findByCategory("MLB27530");
		System.out.println("Manager Created");
	}
	private static void insert() {
		CategoryMetaData bean = new CategoryMetaData();
		bean.setCategoryId("123");
		bean.setCategoryJson("1234");
		bean.setCreationDate(new Date());
		bean.setLastModifiedDate(new Date());
		manager.persist(bean);
	}
	private static void update() {
		CategoryMetaData bean = manager.find(CategoryMetaData.class, "123");
		bean.setCategoryJson("91011");
		manager.merge(bean);
		System.out.println(""+bean);
	}

	private static void delete() {
		CategoryMetaData bean = manager.find(CategoryMetaData.class, "123");
		manager.remove(bean);
	}

	private static void findByCategory(String cat ) {
		CategoryMetaData bean = manager.find(CategoryMetaData.class, cat);
		System.out.println(""+bean);
	}

	
}