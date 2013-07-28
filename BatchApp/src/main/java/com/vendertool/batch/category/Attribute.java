
package com.vendertool.batch.category;

import java.util.List;

public class Attribute{
   	private String attribute_group_id;
   	private String attribute_group_name;
   	private String id;
   	private String name;
   	private Tags tags;
   	private String type;
   	private String value_type;
   	private List<Values> values;

 	public String getAttribute_group_id(){
		return this.attribute_group_id;
	}
	public void setAttribute_group_id(String attribute_group_id){
		this.attribute_group_id = attribute_group_id;
	}
 	public String getAttribute_group_name(){
		return this.attribute_group_name;
	}
	public void setAttribute_group_name(String attribute_group_name){
		this.attribute_group_name = attribute_group_name;
	}
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
 	public Tags getTags(){
		return this.tags;
	}
	public void setTags(Tags tags){
		this.tags = tags;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
 	public String getValue_type(){
		return this.value_type;
	}
	public void setValue_type(String value_type){
		this.value_type = value_type;
	}
 	public List<Values> getValues(){
		return this.values;
	}
	public void setValues(List<Values> values){
		this.values = values;
	}
}