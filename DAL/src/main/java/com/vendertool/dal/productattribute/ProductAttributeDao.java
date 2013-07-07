package com.vendertool.dal.productattribute;

import java.util.List;


public interface ProductAttributeDao {

	void insert (ProductAttribute productAttribute);

	void update(ProductAttribute productAttribute);

	void delete(ProductAttribute productAttribute);

	List<ProductAttribute> findByProductSpecificationId(long accountId);
	
}
