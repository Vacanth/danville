package com.vendertool.batch.product.output;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVWriter;

import com.google.gson.Gson;
import com.vendertool.batch.listing.ProductBean;
import com.vendertool.dal.batchworklog.BatchWorkLog;

@Component("outputFileWriter")
public class ProductOutputFeedWriter implements ItemWriter<List<BatchWorkLog>> {
	private static Gson gson = new Gson();

	@Override
	public void write(List<? extends List<BatchWorkLog>> items)
			throws Exception {
		if (items == null) {
			return;
		}
		if(!(items.size() > 0)){
			return;
		}
		
		List<BatchWorkLog> batchWorkLogs = items.get(0);
		
		for(BatchWorkLog workLog : batchWorkLogs){
			if(workLog == null){
				continue;
			}
			byte[] request = workLog.getResponse();
			String requestString = new String(request);
			ProductBean productBean = gson.fromJson(requestString,
					ProductBean.class);
			String csv = "C:\\output.csv";

			CSVWriter writer = new CSVWriter(new FileWriter(csv));
			 
			String [] country = "India#China#United States".split("#");
			 
			writer.writeNext(country);
			 
			writer.close();
//			writer.
		}
	}
}