package com.vendertool.dal.accountmarketplace;

import java.util.List;


public interface AccountMarketplaceDao {

	void insert (AccountMarketplace accountMarketplace);

	void update(AccountMarketplace accountMarketplace);

	void delete(AccountMarketplace accountMarketplace);

	List<AccountMarketplace> findByAccountId(AccountMarketplace accountMarketplace);
	List<AccountMarketplace> findByMPId(AccountMarketplace accountMarketplace);
	
}
