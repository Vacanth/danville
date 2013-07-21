package com.vendertool.batch;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import com.vendertool.batch.listing.ProductBean;
import com.vendertool.sharedtypes.core.Amount;
import com.vendertool.sharedtypes.core.Classification;
import com.vendertool.sharedtypes.core.Classification.ClassificationTypeEnum;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.core.Listing.ListingFormatEnum;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.core.ProductCodeTypeEnum;

public class BatchListingHelper {

	private static BatchListingHelper s_self = new BatchListingHelper();

	private BatchListingHelper() {

	}

	public static BatchListingHelper getInstance() {
		return s_self;
	}

	public Listing adaptToListing(ProductBean request, Date creationDate) {
		Listing listing = new Listing();
		listing.setCreateDate(creationDate);
		listing.setCondition(request.getItemCondition());
		listing.setListingId(request.getListingTypeId());
		listing.setListingFormat(ListingFormatEnum.AUCTION);//TODO
		listing.setDuration(7);//TODO
		listing.setStartDate(new Date());
		if (request.getCategoryId() != null
				&& request.getCategoryId().length() > 0) {
			Classification classification = new Classification();
			List<Classification> classifs = new ArrayList<Classification>();
			classification.setClassifierId(request.getCategoryId());
			classifs.add(classification);
			listing.setClassification(classifs);
			classification
					.setClassificationType(ClassificationTypeEnum.CATEGORY);
		}
		listing.setQuantity(Integer.valueOf(request.getQuantity()));
		listing.setProduct(adaptToProductRequest(request, creationDate));
		if (request.getPrice() != null && request.getCurrencyCode() != null) {
			Amount amount = new Amount();
			amount.setCurrency(Currency.getInstance(request.getCurrencyCode()));
			amount.setValue(Double.valueOf(request.getPrice()));
			listing.setPrice(amount);
		}
		return listing;
	}

	private Product adaptToProductRequest(ProductBean bean, Date creationDate) {
		if (bean == null) {
			return null;
		}
		Product product = new Product();
		product.setCreateDate(creationDate);
		product.setLastModifiedDate(creationDate);
		product.setDescription(bean.getDescription());
		product.setSku(bean.getSku());
		product.setProductCode(bean.getProductCode());
		ProductCodeTypeEnum productCOde = ProductCodeTypeEnum.valueOf(
				ProductCodeTypeEnum.class, bean.getProductCodeType());
		product.setProductCodeType(productCOde);
		product.setTitle(bean.getTitle());
		// product.setVariations(variations);
		return product;
	}
}