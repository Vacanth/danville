package com.vendertool.metadata;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryMetaDataDAO {

	private static CategoryMetaDataDAO s_self = new CategoryMetaDataDAO();

	private CategoryMetaDataDAO() {

	}

	static EntityManagerFactory emf = null;
	static EntityManager manager = null;

	public static CategoryMetaDataDAO getInstance() {
		if (emf == null || manager == null) {
			emf = Persistence.createEntityManagerFactory("cassandra_pu");
			manager = emf.createEntityManager();
		}
		return s_self;
	}

	public void insert(CategoryMetaData bean) {
		manager.persist(bean);
	}

	public CategoryMetaData findByCategory(String cat) {
		CategoryMetaData bean = manager.find(CategoryMetaData.class, cat);
		return bean;
	}

	public void update(CategoryMetaData bean) {
		manager.merge(bean);
	}
}