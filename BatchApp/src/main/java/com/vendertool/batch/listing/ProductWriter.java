package com.vendertool.batch.listing;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.vendertool.common.user.UserUtils;
import com.vendertool.inventory.IInventoryManagementService;
import com.vendertool.inventory.InventoryManagementServiceImpl;
import com.vendertool.mladapter.factory.IBaseMercadolibreOperationAdapter;
import com.vendertool.mladapter.factory.MercadolibreAdapterFactory;
import com.vendertool.sharedtypes.core.Amount;
import com.vendertool.sharedtypes.core.Classification;
import com.vendertool.sharedtypes.core.Classification.ClassificationTypeEnum;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.core.Listing.ListingFormatEnum;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.core.ProductCodeTypeEnum;
import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.AddListingResponse;
import com.vendertool.sharedtypes.rnr.AddProductRequest;

@Component("productwriter")
public class ProductWriter implements ItemWriter<ProductBean> {
	private StepExecution se;

	@BeforeStep
	public void setExecution(StepExecution se) {
		this.se = se;
	}

	@Override
	public void write(List<? extends ProductBean> arg0) throws Exception {
		for (ProductBean request : arg0) {
			if (request == null) {
				continue;
			}
			IInventoryManagementService service = InventoryManagementServiceImpl
					.getInstance();
			AddProductRequest prodRequest = adaptToProductRequest(request);
			service.addProduct(prodRequest);
			
			// TODO add a helper to prepare Inventory req from bean
			String token = UserUtils.getInstance().getUserAccessToken(request.getUserAccountId());
			//TODO move this listing into
			AddListingRequest req = new AddListingRequest();
			req.setUserAccessToken(token);
			Listing listing = new Listing();
			req.setListing(listing);
			listing.setCreateDate(se.getStartTime());
			listing.setCondition(request.getItemCondition());
			listing.setListingId(request.getListingTypeId());
			listing.setListingFormat(ListingFormatEnum.AUCTION);
			listing.setDuration(7);
			listing.setStartDate(new Date());
			if(request.getCategoryId() != null && request.getCategoryId().length() > 0){
				Classification classification = new Classification();
				List<Classification> classifs = new ArrayList<Classification>();
				classification.setClassifierId(request.getCategoryId());
				classifs.add(classification);
				listing.setClassification(classifs);
				classification.setClassificationType(ClassificationTypeEnum.CATEGORY);
			}
			listing.setQuantity(Integer.valueOf(request.getQuantity()));
			listing.setProduct(prodRequest.getProduct());
			if(request.getPrice() != null && request.getCurrencyCode() != null){
				Amount amount = new Amount ();
				amount.setCurrency(Currency.getInstance(request.getCurrencyCode()));
				amount.setValue(Double.valueOf(request.getPrice()));
				listing.setPrice(amount);
			}
			IBaseMercadolibreOperationAdapter adapter = MercadolibreAdapterFactory.getInstance().getOperationAdapter(req);
			AddListingResponse response = (AddListingResponse)adapter.execute(req);
			System.out.println(response.getListingId());
		}
	}

	private AddProductRequest adaptToProductRequest(ProductBean bean) {
		if (bean == null) {
			return null;
		}
		AddProductRequest productRequest = new AddProductRequest();
		productRequest.setUserId(32456);
		bean.getCategoryId();
		bean.getCurrencyCode();

		Product product = new Product();
		product.setCreateDate(se.getStartTime());
		product.setLastModifiedDate(se.getStartTime());
		product.setDescription(bean.getDescription());
		product.setSku(bean.getSku());
		product.setProductCode(bean.getProductCode());
		ProductCodeTypeEnum productCOde = ProductCodeTypeEnum.valueOf(ProductCodeTypeEnum.class, bean.getProductCodeType());
		product.setProductCodeType(productCOde);
		product.setTitle(bean.getTitle());
		// product.setVariations(variations);
		productRequest.setProduct(product);
		productRequest.setProduct(product);
		return productRequest;
	}
}
