package com.vendertool.dal.productvariationdetails;

import java.util.List;


public interface ProductVariationDetailsDao {

	void insert (ProductVariationDetails productVariationDetails);

	void update(ProductVariationDetails productVariationDetails);

	void delete(ProductVariationDetails productVariationDetails);
	
	List<ProductVariationDetails> findByProductVariationId(long productVariationId);
	
}
