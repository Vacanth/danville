/**
 * 
 */
package com.vendertool.dal.image;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;

import com.vendertool.dal.BaseDaoImpl;
import com.vendertool.dal.batchworklog.BatchWorkLogDao;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ImageDaoImpl extends BaseDaoImpl implements ImageDao {
	static private ImageDao imageDao;
	public static ImageDao getInstance() {
		if (imageDao == null) {
			ApplicationContext appContext = getAppContext();
			imageDao = (ImageDao) appContext
					.getBean("imageDao");
		}
		return imageDao;
	}
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (Image image) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(image);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Image image) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(image);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Image image) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(image);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Image> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from image where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(Image.class);
		List<Image> results = query.list();
		return  results;
	}
	public List<Image> findByAccountIdAndImageId(long accountId, long imageId) {
		// TODO Auto-generated method stub
		String sql = "select * from image where account_id = :account_id and image_id = :image_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(Image.class);
		query.setParameter("image_id", imageId);
		query.addEntity(Image.class);
		List<Image> results = query.list();
		return  results;
	}

}
