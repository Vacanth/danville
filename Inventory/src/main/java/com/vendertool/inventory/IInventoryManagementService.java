package com.vendertool.inventory;

import com.vendertool.common.service.IVenderToolService;
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

public interface IInventoryManagementService extends IVenderToolService{
	/**
	 * HTTP GET call to get the product
	 * 
	 * @param productId
	 * @return
	 */
	public GetProductResponse getProduct(String productId);

	/**
	 * HTTP POST call to add the product
	 * 
	 * @param request
	 * @return
	 */
	public AddProductResponse addProduct(AddProductRequest request);
	
	/**
	 * HTTP POST call to update the product
	 * 
	 * @param request
	 * @return
	 */
	public UpdateProductResponse updateProduct(UpdateProductRequest request);
	
	/**
	 * HTTP GET call to remove the product
	 * 
	 * @param productId
	 * @return
	 */
	public RemoveProductResponse removeProduct(String productId);
	
	/**
	 * HTTP POST call to update the price and quantity
	 * 
	 * @param request
	 * @return
	 */
	public UpdateProductPriceQuanityResponse updateProductPriceQuantity(UpdateProductPriceQuantityRequest request);
	
	/**
	 * HTTP POST call to increment or decrement the quantity
	 * 
	 * @param request
	 * @return
	 */
	public AdjustProductQuantityResponse adjustQuantity(AdjustProductQuantityRequest request);
	
	/**
	 * HTTP GET call to duplicate and create a new product
	 * 
	 * @param request
	 * @return
	 */
	public DuplicateProductResponse duplicateProduct(String productId);
	
	/**
	 * HTTP POST call to add a product variation to an existing product
	 * 
	 * @param request
	 * @return
	 */
	public AddProductVariationResponse addProductVariation(AddProductVariationRequest request);
	
	/**
	 * HTTP GET call to remove the product variation from an existing product
	 * 
	 * @param request
	 * @return
	 */
	public RemoveProductVariationResponse removeProductVariation(String productId, String variationId);
	
	/**
	 * HTTP GET to get the product variation from an existing product
	 * 
	 * @param request
	 * @return
	 */
	public GetProductVariationResponse getProductVariation(String productId, String variationId);
	
	/**
	 * HTTP POST add an image to the existing product
	 * 
	 * @param request
	 * @return
	 */
	public AddProductImageResponse addProductImage(AddProductImageRequest request);

}
