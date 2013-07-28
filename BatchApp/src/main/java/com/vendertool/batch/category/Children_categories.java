
package com.vendertool.batch.category;


public class Children_categories{
   	private String id;
   	private String name;
   	private Number total_items_in_this_category;

 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getTotal_items_in_this_category(){
		return this.total_items_in_this_category;
	}
	public void setTotal_items_in_this_category(Number total_items_in_this_category){
		this.total_items_in_this_category = total_items_in_this_category;
	}
}