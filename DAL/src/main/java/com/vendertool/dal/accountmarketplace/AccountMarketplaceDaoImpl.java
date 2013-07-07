/**
 * 
 */
package com.vendertool.dal.accountmarketplace;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.dal.BaseDaoImpl;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class AccountMarketplaceDaoImpl extends BaseDaoImpl implements AccountMarketplaceDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (AccountMarketplace accountMarketplace) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(accountMarketplace);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(AccountMarketplace accountMarketplace) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(accountMarketplace);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(AccountMarketplace accountMarketplace) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(accountMarketplace);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<AccountMarketplace> findByAccountId(AccountMarketplace accountMarketplace) {
		// TODO Auto-generated method stub
		String sql = "select * from account_marketplace where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountMarketplace.getAccountId());
		query.addEntity(AccountMarketplace.class);
		List<AccountMarketplace> results = query.list();
		return  results;
	}

	public List<AccountMarketplace> findByMPId(
			AccountMarketplace accountMarketplace) {
		String sql = "select * from account_marketplace where mp_id = :mp_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("mp_id", accountMarketplace.getMpId());
		query.addEntity(AccountMarketplace.class);
		List<AccountMarketplace> results = query.list();
		return  results;
	}

}
