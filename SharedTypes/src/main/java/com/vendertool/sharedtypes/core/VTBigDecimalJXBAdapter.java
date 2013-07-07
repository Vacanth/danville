package com.vendertool.sharedtypes.core;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class VTBigDecimalJXBAdapter extends XmlAdapter<String, BigDecimal> {
    public BigDecimal unmarshal(String val) {
        return new BigDecimal(val);
    }
    public String marshal(BigDecimal val) {
        return val.toString();
    }
}