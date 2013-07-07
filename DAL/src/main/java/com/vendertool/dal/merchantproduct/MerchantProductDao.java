package com.vendertool.dal.merchantproduct;

import java.util.List;


public interface MerchantProductDao {

	void insert (MerchantProduct merchantProduct);

	void update(MerchantProduct merchantProduct);

	void delete(MerchantProduct merchantProduct);

	List<MerchantProduct> findByAccountId(long accountId);
	List<MerchantProduct> findByAccountIdAndSKU(long accountId,String sku);
	
	List<MerchantProduct> findByProductId(long productId);
	
}
