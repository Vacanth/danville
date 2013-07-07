package com.vendertool.sharedtypes.core;

import java.util.Currency;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class VTCurrencyJXBAdapter extends XmlAdapter<String,Currency> {
    public Currency unmarshal(String val) {
        return Currency.getInstance(val);
    }
    public String marshal(Currency val) {
        return val.toString();
    }
}
