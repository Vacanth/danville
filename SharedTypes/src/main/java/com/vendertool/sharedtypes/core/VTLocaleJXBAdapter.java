package com.vendertool.sharedtypes.core;

import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class VTLocaleJXBAdapter extends XmlAdapter<String,Locale> {
    public Locale unmarshal(String val) {
        return fromString(val);
    }
    public String marshal(Locale val) {
        return val.toString();
    }
    
    public static Locale fromString(String locale) {
    	if((locale == null) || (locale.trim().isEmpty())) {
    		return null;
    	}
    	
        String parts[] = locale.split("_", -1);
        if (parts.length == 1) return new Locale(parts[0]);
        else if (parts.length == 2) return new Locale(parts[0], parts[1]);
        else return new Locale(parts[0], parts[1], parts[2]);
    }
}