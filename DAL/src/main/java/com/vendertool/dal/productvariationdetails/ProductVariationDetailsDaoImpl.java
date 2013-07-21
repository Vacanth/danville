/**
 * 
 */
package com.vendertool.dal.productvariationdetails;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;

import com.vendertool.dal.BaseDaoImpl;
import com.vendertool.dal.productvariation.ProductVariationDao;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ProductVariationDetailsDaoImpl extends BaseDaoImpl implements ProductVariationDetailsDao {

	static private ProductVariationDetailsDao productVariationDetailsDao;
	public static ProductVariationDetailsDao getInstance() {
		if (productVariationDetailsDao == null) {
			ApplicationContext appContext = getAppContext();
			productVariationDetailsDao = (ProductVariationDetailsDao) appContext
					.getBean("productVariationDetailsDao");
		}
		return productVariationDetailsDao;
	}
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductVariationDetails productVariationDetails) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productVariationDetails);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductVariationDetails productVariationDetails) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productVariationDetails);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductVariationDetails productVariationDetails) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productVariationDetails);

	}


	public List<ProductVariationDetails> findByProductVariationId(long productVariationId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Variation_Details where product_variations_id = :product_variations_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_variations_id", productVariationId);
		query.addEntity(ProductVariationDetails.class);
		List<ProductVariationDetails> results = query.list();
		return  results;
	}
	public List<ProductVariationDetails> findByProductIdAndVariationId(long productId,long productVariationId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Variation_Details where product_id = :product_id and product_variations_id = :product_variations_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_id", productVariationId);
		query.setParameter("product_variations_id", productVariationId);
		query.addEntity(ProductVariationDetails.class);
		List<ProductVariationDetails> results = query.list();
		return  results;
	}
	
	
}
