package com.vendertool.batch;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import com.vendertool.batch.listing.ProductBean;
import com.vendertool.sharedtypes.core.Amount;
import com.vendertool.sharedtypes.core.Classification;
import com.vendertool.sharedtypes.core.NameValuePair;
import com.vendertool.sharedtypes.core.ProductVariation;
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

	public Listing adaptToListing(List<ProductBean> beans , Date creationDate) {
		if(beans == null){
			return null;
		}
		ProductBean bean = beans.get(0);
		if(bean == null){
			return null;
		}
		;
		Listing listing = new Listing();
		listing.setCreateDate(creationDate);
		listing.setCondition(bean.getItemCondition());
		listing.setListingId(bean.getListingTypeId());
		listing.setListingFormat(ListingFormatEnum.AUCTION);//TODO
		listing.setDuration(7);//TODO
		listing.setStartDate(new Date());
		if (bean.getCategoryId() != null
				&& bean.getCategoryId().length() > 0) {
			Classification classification = new Classification();
			List<Classification> classifs = new ArrayList<Classification>();
			classification.setClassifierId(bean.getCategoryId());
			classifs.add(classification);
			listing.setClassification(classifs);
			classification
					.setClassificationType(ClassificationTypeEnum.CATEGORY);
		}
		listing.setQuantity(Integer.valueOf(bean.getQuantity()));
		listing.setProduct(adaptToProductRequest(beans, creationDate));
		if (bean.getPrice() != null && bean.getCurrencyCode() != null) {
			Amount amount = new Amount();
			amount.setCurrency(Currency.getInstance(bean.getCurrencyCode()));
			amount.setValue(Double.valueOf(bean.getPrice()));
			listing.setPrice(amount);
		}
		return listing;
	}

	private Product adaptToProductRequest(List<ProductBean> beans, Date creationDate) {
		if (beans == null) {
			return null;
		}
		Product product = new Product();
		
		List<ProductVariation> variations = new ArrayList<ProductVariation>();
		for(ProductBean bean : beans){
			if(bean == null){
				continue;
			}
			ProductVariation variation = new ProductVariation();
			
			if (bean.getPrice() != null && bean.getCurrencyCode() != null) {
				Amount amount = new Amount();
				amount.setCurrency(Currency.getInstance(bean.getCurrencyCode()));
				amount.setValue(Double.valueOf(bean.getPrice()));
				variation.setPrice(amount);
			}
			variation.setQuantity(Integer.valueOf(bean.getQuantity()));
			variation.setSku(bean.getSku());
			variation.setTitle(bean.getTitle());
			/*variation.setProductVariationId(productVariationId);
			variation.setProductCode(productCode);*/
			
			List<NameValuePair> properties = new ArrayList<NameValuePair>();
			variation.setProperties(properties);
			variations.add(variation);
		}
		product.setVariations(variations);
		
		product.setCreateDate(creationDate);
		product.setLastModifiedDate(creationDate);
	/*	product.setDescription(bean.getDescription());
		product.setSku(bean.getSku());
		product.setProductCode(bean.getProductCode());
		ProductCodeTypeEnum productCOde = ProductCodeTypeEnum.valueOf(
				ProductCodeTypeEnum.class, bean.getProductCodeType());
		product.setProductCodeType(productCOde);
		product.setTitle(bean.getTitle());*/
		// product.setVariations(variations);
		return product;
	}
}