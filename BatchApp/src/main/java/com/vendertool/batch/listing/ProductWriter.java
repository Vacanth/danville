package com.vendertool.batch.listing;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.vendertool.inventory.IInventoryManagementService;
import com.vendertool.inventory.InventoryManagementServiceImpl;
import com.vendertool.sharedtypes.rnr.AddProductRequest;

@Component("productwriter")
public class ProductWriter implements ItemWriter<AddProductRequest> {

	@Override
	public void write(List<? extends AddProductRequest> arg0) throws Exception {
		for(AddProductRequest request : arg0){
			if(request == null){
				continue;
			}
			IInventoryManagementService service = InventoryManagementServiceImpl.getInstance();
			service.addProduct(request);
		}
	}
}