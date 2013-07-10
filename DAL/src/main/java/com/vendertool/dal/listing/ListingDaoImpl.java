/**
 * 
 */
package com.vendertool.dal.listing;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;

import com.vendertool.dal.image.Image;
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
		String sql = "select * from listing where listing_id = :listing_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("listing_id", listingId);
		query.addEntity(Listing.class);
		List<Listing> results = query.list();
		return  results;
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Listing> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from listing where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(Listing.class);
		List<Listing> results = query.list();
		return  results;
	}
	public List<Listing> findByAccountIdAndListingId(long accountId,
			long listingId) {
		// TODO Auto-generated method stub
		String sql = "select * from listing where account_id = :account_id and listing_id = :listing_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(Listing.class);
		query.setParameter("listing_id", listingId);
		query.addEntity(Listing.class);
		List<Listing> results = query.list();
		return  results;
	}
}