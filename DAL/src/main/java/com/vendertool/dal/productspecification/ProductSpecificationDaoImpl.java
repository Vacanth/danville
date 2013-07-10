/**
 * 
 */
package com.vendertool.dal.productspecification;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;

import com.vendertool.dal.BaseDaoImpl;
import com.vendertool.dal.productdescription.ProductDescriptionDao;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ProductSpecificationDaoImpl extends BaseDaoImpl implements ProductSpecificationDao {

	static private ProductSpecificationDao productSpecificationDao;
	public static ProductSpecificationDao getInstance() {
		if (productSpecificationDao == null) {
			ApplicationContext appContext = getAppContext();
			productSpecificationDao = (ProductSpecificationDao) appContext
					.getBean("productSpecificationDao");
		}
		return productSpecificationDao;
	}
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductSpecification productSpecification) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productSpecification);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductSpecification productSpecification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productSpecification);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductSpecification productSpecification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productSpecification);

	}


	public List<ProductSpecification> findByproductSpecificationId(
			long productSpecificationId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Specification where product_specification_id = :product_specification_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_specification_id", productSpecificationId);
		query.addEntity(ProductSpecification.class);
		List<ProductSpecification> results = query.list();
		return  results;
	}
	public List<ProductSpecification> findByproductProductId(long productId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Specification where product_id = :product_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_id", productId);
		query.addEntity(ProductSpecification.class);
		List<ProductSpecification> results = query.list();
		return  results;
	}

}
