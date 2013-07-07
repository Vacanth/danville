/**
 * 
 */
package com.vendertool.dal.productattribute;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.dal.BaseDaoImpl;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ProductAttributeDaoImpl extends BaseDaoImpl implements ProductAttributeDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productAttribute);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productAttribute);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productAttribute);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ProductAttribute> findByProductSpecificationId(long productSpecificationId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Attribute where PRODUCT_SPECIFICATION_ID = :PRODUCT_SPECIFICATION_ID";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("PRODUCT_SPECIFICATION_ID", productSpecificationId);
		query.addEntity(ProductAttribute.class);
		List<ProductAttribute> results = query.list();
		return  results;
	}

}
