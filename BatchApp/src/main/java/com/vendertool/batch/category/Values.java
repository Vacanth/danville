
package com.vendertool.batch.category;


public class Values{
   	private String id;
   	private Metadata metadata;
   	private String name;

 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public Metadata getMetadata(){
		return this.metadata;
	}
	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}