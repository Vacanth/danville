/**
 * 
 */
package com.vendertool.dal.listing;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.vendertool.dal.image.ImageDao;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ListingDaoImpl extends com.vendertool.dal.BaseDaoImpl implements ListingDao {

	static private ListingDao listingDao;
	public static ListingDao getInstance() {
		if (listingDao == null) {
			ApplicationContext appContext = getAppContext();
			listingDao = (ListingDao) appContext
					.getBean("listingDao");
		}
		return listingDao;
	}
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (Listing listing) {
		// TODO Auto-generated method stub
		
//		getHibernateTemplate().save(listing);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Listing listing) {
		// TODO Auto-generated method stub
//		getHibernateTemplate().update(listing);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Listing listing) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().delete(listing);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Listing> findByListingId(long listingId) {
		// TODO Auto-generated method stub
		return  null;
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Listing> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		return  null;
	}
}