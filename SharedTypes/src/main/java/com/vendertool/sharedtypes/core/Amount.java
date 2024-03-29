package com.vendertool.sharedtypes.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Amount {
	private static final Locale DEFAULT_LOCALE = Locale.US;
	private static final Currency DEFAULT_CURRENCY = Currency.getInstance(DEFAULT_LOCALE);
	
	private double value;

	private Currency currency;
	
	private Locale locale;
	
	public Amount() {
		this(0);
	}
	/**
	 * Amount constructor that default the value to US Currency & US Locale
	 *  
	 * @param value
	 */
	public Amount(double value){
		this(value, DEFAULT_CURRENCY, DEFAULT_LOCALE);
	}
	
	/**
	 * Amount constructor that uses BigDecimal to set the scale of 2 and rounds the value to RoundingMode.CEILING
	 * 
	 * @param value
	 * @param currency
	 * @param locale
	 */
	public Amount(double value, Currency currency, Locale locale) {
		if((currency == null) || (locale == null)) {
			
		}
		
		this.value = value;
		this.currency = currency;
		this.locale = locale;
	}
	
	/**
	 * Formats the value to the defined currency and locale
	 * 
	 * Need to have our custom pattern to format the amount
	 * 
	 * @return
	 */
	public String getValueFormat(){
		NumberFormat currencyFormatter = 
		        NumberFormat.getCurrencyInstance(locale);
		
		return currencyFormatter.format(value);
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
