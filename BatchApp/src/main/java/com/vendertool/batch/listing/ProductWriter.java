package com.vendertool.batch.listing;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.vendertool.inventory.IInventoryManagementService;
import com.vendertool.inventory.InventoryManagementServiceImpl;
import com.vendertool.sharedtypes.rnr.AddProductRequest;

@Component("productwriter")
public class ProductWriter implements ItemWriter<ProductBean> {

	@Override
	public void write(List<? extends ProductBean> arg0) throws Exception {
		for(ProductBean request : arg0){
			if(request == null){
				continue;
			}
			AddProductRequest request1 = new AddProductRequest();
			IInventoryManagementService service = InventoryManagementServiceImpl.getInstance();
			service.addProduct(request1);
			//TODO add a helper to prepare Inventory req from bean
		}
	}
}