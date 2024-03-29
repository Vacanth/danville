/**
 * 
 */
package com.vendertool.dal.productdescription;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;

import com.vendertool.dal.BaseDaoImpl;
import com.vendertool.dal.productattribute.ProductAttributeDao;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ProductDescriptionDaoImpl extends BaseDaoImpl implements ProductDescriptionDao {


	static private ProductDescriptionDao productDescriptionDao;
	public static ProductDescriptionDao getInstance() {
		if (productDescriptionDao == null) {
			ApplicationContext appContext = getAppContext();
			productDescriptionDao = (ProductDescriptionDao) appContext
					.getBean("productDescriptionDao");
		}
		return productDescriptionDao;
	}
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductDescription productDescription) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productDescription);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductDescription productDescription) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productDescription);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductDescription productDescription) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productDescription);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ProductDescription> findByProductId(long productId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Description where product_id = :product_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_id", productId);
		query.addEntity(ProductDescription.class);
		List<ProductDescription> results = query.list();
		return  results;
	}

}
