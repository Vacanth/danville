package com.vendertool.batch.mappers;

import java.util.HashMap;
import java.util.Map;

public class CSVMapHelper {
	
	private static CSVMapHelper s_self = new CSVMapHelper();
	
	public static CSVMapHelper getInstance(){
		return s_self;
	}
	
	public Map<String, String> getProductFeedMapper(){
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("handle", "handle");
		columnMapping.put("sku", "sku");
		columnMapping.put("variant_option_one_name", "type");
		return columnMapping;
	}
}