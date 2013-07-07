/**
 * 
 */
package com.vendertool.dal.account;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.dal.BaseDaoImpl;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class AccountDaoImpl extends BaseDaoImpl implements AccountDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (Account account) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(account);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Account account) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(account);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Account account) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(account);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Account> findByAccountId(Account account) {
		// TODO Auto-generated method stub
		String sql = "select * from account where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", account.getAccountId());
		query.addEntity(Account.class);
		List<Account> results = query.list();
		return  results;
	}

}
