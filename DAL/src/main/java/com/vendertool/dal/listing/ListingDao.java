package com.vendertool.dal.listing;

import java.util.List;


public interface ListingDao {

	void insert (Listing listing);

	void update(Listing listing);

	void delete(Listing listing);

	List<Listing> findByListingId(long listingId);
	
	List<Listing> findByAccountId(long listingId);
	
}
