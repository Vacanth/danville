package com.vendertool.dal.productvariation;

import java.util.List;


public interface ProductVariationDao {

	void insert (ProductVariation productVariation);

	void update(ProductVariation productVariation);

	void delete(ProductVariation productVariation);

	List<ProductVariation> findByProductId(long productId);
	
	List<ProductVariation> findByProductVariationId(long productVariationId);
	List<ProductVariation> findByProductIdAndVariationName(long productId, String variationname);
	
}
