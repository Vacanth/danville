/**
 * 
 */
package com.vendertool.dal.productvariation;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;

import com.vendertool.dal.BaseDaoImpl;
import com.vendertool.dal.productspecification.ProductSpecificationDao;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ProductVariationDaoImpl extends BaseDaoImpl implements ProductVariationDao {

	static private ProductVariationDao productVariationDao;
	public static ProductVariationDao getInstance() {
		if (productVariationDao == null) {
			ApplicationContext appContext = getAppContext();
			productVariationDao = (ProductVariationDao) appContext
					.getBean("productVariationDao");
		}
		return productVariationDao;
	}
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductVariation productVariation) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productVariation);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductVariation productVariation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productVariation);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductVariation productVariation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productVariation);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ProductVariation> findByProductId(long productId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Variation where product_id = :product_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_id", productId);
		query.addEntity(ProductVariation.class);
		List<ProductVariation> results = query.list();
		return  results;
	}
	
	public List<ProductVariation> findByProductVariationId(long productVariationId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Variation where product_variations_id = :product_variations_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_variations_id", productVariationId);
		query.addEntity(ProductVariation.class);
		List<ProductVariation> results = query.list();
		return  results;
	}

	public List<ProductVariation> findByProductIdAndVariationName(long productId,
			String variationName) {
		String sql = "select * from Product_Variation where product_id = :product_id and variation_name= :variation_name";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_id", productId);
		query.addEntity(ProductVariation.class);
		query.setParameter("variation_name", variationName);
		query.addEntity(ProductVariation.class);
		List<ProductVariation> results = query.list();
		return  results;
	}

}
