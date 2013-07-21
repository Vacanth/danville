/**
 * 
 */
package com.vendertool.dal.accountmarketplace;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;

import com.vendertool.dal.BaseDaoImpl;
import com.vendertool.dal.account.AccountDao;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class AccountMarketplaceDaoImpl extends BaseDaoImpl implements AccountMarketplaceDao {

	static private AccountMarketplaceDao accountMarketplaceDao;
	public static AccountMarketplaceDao getInstance() {
		if (accountMarketplaceDao == null) {
			ApplicationContext appContext = getAppContext();
			accountMarketplaceDao = (AccountMarketplaceDao) appContext
					.getBean("accountMarketplaceDao");
		}
		return accountMarketplaceDao;
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 * 
	 * 
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

	public List<AccountMarketplace> findByAccountAndMPId(
			AccountMarketplace accountMarketplace) {
		String sql = "select * from account_marketplace where account_id = :account_id and mp_id = :mp_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountMarketplace.getAccountId());
		query.setParameter("mp_id", accountMarketplace.getMpId());
		query.addEntity(AccountMarketplace.class);
		List<AccountMarketplace> results = query.list();
		return  results;
	}

	public List<AccountMarketplace> findByExpiryDatetime(Date date) {
		String sql = "select * from account_marketplace where expiry_date <= :expery_date";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("expery_date", date);
		query.addEntity(AccountMarketplace.class);
		List<AccountMarketplace> results = query.list();
		return  results;
	}

}
