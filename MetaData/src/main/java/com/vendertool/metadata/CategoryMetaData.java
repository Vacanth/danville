package com.vendertool.metadata;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 CREATE KEYSPACE meta_data
with placement_strategy = 'org.apache.cassandra.locator.SimpleStrategy'
and strategy_options = [{replication_factor:1}];

CREATE COLUMN FAMILY category
WITH comparator = UTF8Type
AND key_validation_class=UTF8Type
AND column_metadata = [
{column_name: category_id, validation_class: UTF8Type}
{column_name: category_data, validation_class: UTF8Type}
{column_name: category_attr, validation_class: UTF8Type}
{column_name: creation_date, validation_class: DateType}
{column_name: lastmodified_date, validation_class: DateType}

];
 */
@Entity
@Table(name = "category", schema = "meta_data@cassandra_pu")
public class CategoryMetaData {

	@Id
	@Column(name = "category_id")
	private String categoryId;
	@Column(name = "category_data")
	private String categoryJson;
	@Column(name = "category_attr")
	private String categoryAttrJson;
	@Column(name = "creation_date")
	private Date creationDate;
	@Column(name = "lastmodified_date")
	private Date lastModifiedDate;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryJson() {
		return categoryJson;
	}

	public void setCategoryJson(String categoryJson) {
		this.categoryJson = categoryJson;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCategoryAttrJson() {
		return categoryAttrJson;
	}

	public void setCategoryAttrJson(String categoryAttrJson) {
		this.categoryAttrJson = categoryAttrJson;
	}
}