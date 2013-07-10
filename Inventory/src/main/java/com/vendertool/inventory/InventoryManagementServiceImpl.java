package com.vendertool.inventory;

import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.dal.merchantproduct.MerchantProduct;
import com.vendertool.dal.merchantproduct.MerchantProductDao;
import com.vendertool.dal.merchantproduct.MerchantProductDaoImpl;
import com.vendertool.sharedtypes.core.InventoryErrorCode;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.core.VTError;
import com.vendertool.sharedtypes.core.VTErrorDomainEnum;
import com.vendertool.sharedtypes.core.VTErrorSeverityEnum;
import com.vendertool.sharedtypes.rnr.AddProductImageRequest;
import com.vendertool.sharedtypes.rnr.AddProductImageResponse;
import com.vendertool.sharedtypes.rnr.AddProductRequest;
import com.vendertool.sharedtypes.rnr.AddProductResponse;
import com.vendertool.sharedtypes.rnr.AddProductVariationRequest;
import com.vendertool.sharedtypes.rnr.AddProductVariationResponse;
import com.vendertool.sharedtypes.rnr.AdjustProductQuantityRequest;
import com.vendertool.sharedtypes.rnr.AdjustProductQuantityResponse;
import com.vendertool.sharedtypes.rnr.DuplicateProductResponse;
import com.vendertool.sharedtypes.rnr.GetProductResponse;
import com.vendertool.sharedtypes.rnr.GetProductVariationResponse;
import com.vendertool.sharedtypes.rnr.RemoveProductResponse;
import com.vendertool.sharedtypes.rnr.RemoveProductVariationResponse;
import com.vendertool.sharedtypes.rnr.UpdateProductPriceQuanityResponse;
import com.vendertool.sharedtypes.rnr.UpdateProductPriceQuantityRequest;
import com.vendertool.sharedtypes.rnr.UpdateProductRequest;
import com.vendertool.sharedtypes.rnr.UpdateProductResponse;

public class InventoryManagementServiceImpl extends BaseVenderToolServiceImpl implements
		IInventoryManagementService {
	private static IInventoryManagementService s_self;
	static public IInventoryManagementService getInstance(){
		if(s_self == null){
			s_self = new InventoryManagementServiceImpl();
		}
		return s_self;
	}
	
	public GetProductResponse getProduct(String id) {
		GetProductResponse response = new GetProductResponse();
		Product product = new Product("iPhone 5");
		String pid = "P123456789";
		if(id == null) {
			id = pid;
		}
		product.setProductId(id);
		response.setProduct(product);
		response.addError(new VTError(
				InventoryErrorCode.INSUFFICIENT_PRODUCT_INFORMATION,
				"Insuffient product information", VTErrorSeverityEnum.WARNING,
				VTErrorDomainEnum.INVENTORY));
		
		return response;
	}

	public AddProductResponse addProduct(AddProductRequest request) {
		Product product = request.getProduct();
		System.out.println("/inventory/addproduct/ call. Adding product ... " + product.toString());
		
		AddProductResponse response = new AddProductResponse();
		response.setProductId("P987654321");
		MerchantProduct merchProduct = new MerchantProduct();
		merchProduct.setAccountId(2345l);
		merchProduct.setLastModifiedApp((byte)1);
		merchProduct.setMerchantProductId(1234l);
		merchProduct.setProductCode(product.getProductCode());
		merchProduct.setProductCodeType((byte)product.getProductCodeType().getId());
		merchProduct.setSku(product.getSku());
		merchProduct.setTitle(product.getTitle());
		MerchantProductDao dao = MerchantProductDaoImpl.getInstance();
		dao.insert(merchProduct);
		return response;
	}

	public UpdateProductResponse updateProduct(UpdateProductRequest request) {
		return null;
	}

	public RemoveProductResponse removeProduct(String productId) {
		return null;
	}

	public UpdateProductPriceQuanityResponse updateProductPriceQuantity(
			UpdateProductPriceQuantityRequest request) {
		return null;
	}

	public AdjustProductQuantityResponse adjustQuantity(
			AdjustProductQuantityRequest request) {
		return null;
	}

	public DuplicateProductResponse duplicateProduct(String productId) {
		return null;
	}

	public AddProductVariationResponse addProductVariation(
			AddProductVariationRequest request) {
		return null;
	}

	public RemoveProductVariationResponse removeProductVariation(
			String productId, String variationId) {
		return null;
	}

	public GetProductVariationResponse getProductVariation(String productId,
			String variationId) {
		return null;
	}

	public AddProductImageResponse addProductImage(
			AddProductImageRequest request) {
		return null;
	}
}
