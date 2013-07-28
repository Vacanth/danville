
package com.vendertool.batch.category;

import java.util.List;

public class Category{
   	private String attribute_types;
   	private List<Children_categories> children_categories;
   	private String id;
   	private String name;
   	private List<Path_from_root> path_from_root;
   	private String permalink;
   	private Settings settings;
   	private Number total_items_in_this_category;

 	public String getAttribute_types(){
		return this.attribute_types;
	}
	public void setAttribute_types(String attribute_types){
		this.attribute_types = attribute_types;
	}
 	public List<Children_categories> getChildren_categories(){
		return this.children_categories;
	}
	public void setChildren_categories(List<Children_categories> children_categories){
		this.children_categories = children_categories;
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
 	public List<Path_from_root> getPath_from_root(){
		return this.path_from_root;
	}
	public void setPath_from_root(List<Path_from_root> path_from_root){
		this.path_from_root = path_from_root;
	}
 	public String getPermalink(){
		return this.permalink;
	}
	public void setPermalink(String permalink){
		this.permalink = permalink;
	}
 	public Settings getSettings(){
		return this.settings;
	}
	public void setSettings(Settings settings){
		this.settings = settings;
	}
 	public Number getTotal_items_in_this_category(){
		return this.total_items_in_this_category;
	}
	public void setTotal_items_in_this_category(Number total_items_in_this_category){
		this.total_items_in_this_category = total_items_in_this_category;
	}
}
