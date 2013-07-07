/**
 * 
 */
package com.vendertool.dal.address;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.dal.BaseDaoImpl;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
/*	public void insert (Address address) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = super.getSession();
		session.setFlushMode(FlushMode.MANUAL );
		session.save(address);
		session.flush();
	}
	
	public void insert (Address address,FlushMode flushMode ) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = super.getSession();
		session.setFlushMode(flushMode);
		
		session.save(address);
		session.flush();
	
	}*/

	public void insert(Address address) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(address);

	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Address address) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(address);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Address address) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(address);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Address> findByAddressId(Address address) {
		// TODO Auto-generated method stub
		String sql = "select * from address where address_id = :address_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("address_id", address.getAddressId());
		query.addEntity(Address.class);
		List<Address> results = query.list();
		return results;
	}

}
