package com.vendertool.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseVenderToolServiceImpl implements IVenderToolService {

	public static final String VERSION_RESOURCE = "../parent/VenderToolVersion.properties";
	
	public String getVersion() {
		String path = "VenderToolVersion.properties";
		InputStream stream = getClass().getResourceAsStream(path);
		if (stream == null) {
			return "UNKNOWN";
		}
		
	    Properties props = new Properties();
	    try {
	    	props.load(stream);
	 	    stream.close();
	 	    return (String)props.get("vendertool.version");
	     } catch (IOException e) {
	 	    return "UNKNOWN";
	 	 }
	}
}