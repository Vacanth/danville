package com.vendertool.dal.address;

import java.util.List;



public interface AddressDao {

	void insert (Address address);
	
	//void insert (Address address,FlushMode flushMode );

	void update(Address address);

	void delete(Address address);

	List <Address> findByAddressId(Address address);
	
}
