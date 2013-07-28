
package com.vendertool.batch.category;


public class Tags{
   	private boolean allow_variations;
   	private boolean required;

 	public boolean getAllow_variations(){
		return this.allow_variations;
	}
	public void setAllow_variations(boolean allow_variations){
		this.allow_variations = allow_variations;
	}
 	public boolean getRequired(){
		return this.required;
	}
	public void setRequired(boolean required){
		this.required = required;
	}
}