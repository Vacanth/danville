package com.vendertool.dal.productspecification;

import java.util.List;


public interface ProductSpecificationDao {

	void insert (ProductSpecification productSpecification);

	void update(ProductSpecification productSpecification);

	void delete(ProductSpecification productSpecification);

	List<ProductSpecification> findByproductSpecificationId(long productSpecificationId);
	List<ProductSpecification> findByproductProductId(long productId);
	
}
