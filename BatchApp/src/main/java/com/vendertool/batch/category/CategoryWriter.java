package com.vendertool.batch.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.vendertool.metadata.CategoryMetaData;
import com.vendertool.metadata.CategoryMetaDataDAO;

@Component("categorySyncWriter")
public class CategoryWriter implements ItemWriter<Category> {

	private static String REPLACE_CAT = "#####";
	private static String s_categoryAttrURL = "https://api.mercadolibre.com/categories/"
			+ REPLACE_CAT + "/attributes/";

	private static Gson gson = new Gson();

	private static int exceptionCount = 0;
	private static int numberOfAttrCount = 0;
	private static int numberOfNoAttrCount = 0;

	private StepExecution se;

	@Override
	public void write(List<? extends Category> items) throws Exception {
		if (items != null && items.size() > 0) {
			Gson gson = new Gson();
			for (Category cat : items) {
				if (cat == null) {
					continue;
				}
				String categoryId = cat.getId();

				CategoryMetaDataDAO catDAO = CategoryMetaDataDAO.getInstance();

				CategoryMetaData metaFromDB = catDAO.findByCategory(categoryId);
				String categoryAttrs = null; 
				if(cat.getAttribute_types() != null && cat.getAttribute_types().length() > 0 && !"none".equals(cat.getAttribute_types()) ){
					categoryAttrs = getCategoryAttrs(categoryId);
				}
				String categoryData = gson.toJson(cat);

				if (metaFromDB != null) {
					metaFromDB.setCategoryId(categoryId);
					if (categoryAttrs != null) {
						metaFromDB.setCategoryAttrJson(categoryAttrs);
					}
					metaFromDB.setCategoryJson(categoryData);
					metaFromDB.setLastModifiedDate(se.getStartTime());
					CategoryMetaDataDAO.getInstance().update(metaFromDB);
				} else {
					CategoryMetaData meta = new CategoryMetaData();
					meta.setCategoryId(categoryId);
					if (categoryAttrs != null) {
						meta.setCategoryAttrJson(categoryAttrs);
					}
					meta.setCategoryJson(categoryData);
					meta.setLastModifiedDate(se.getStartTime());
					meta.setCreationDate(se.getStartTime());
					CategoryMetaDataDAO.getInstance().insert(meta);
				}
			}
		}
	}

	private String getCategoryAttrs(String categoryId) {
		try {
			WebResource resource = Client.create().resource(
					s_categoryAttrURL.replaceAll(REPLACE_CAT, categoryId));
			MediaType mediaType[] = new MediaType[1];
			mediaType[0] = MediaType.APPLICATION_JSON_TYPE;
			ClientResponse response = (ClientResponse) resource.accept(
					mediaType).get(ClientResponse.class);
			if (response != null && response.getStatus() == 200) {
				String output = (String) response.getEntity(String.class);
				 Attribute[] attr = gson.fromJson(output, Attribute[].class);
				System.out.println("" + attr);
				if(attr != null){
					List<Attribute> listAttr = Arrays.asList(attr);
					numberOfAttrCount++;
					return gson.toJson(listAttr);
				}
			}
		} catch (JsonParseException jsonExcepNoData) {
			numberOfNoAttrCount++;
		} catch (Exception excp) {
			exceptionCount++;
			System.out.println("Exception");
		}
		return null;
	}

	@BeforeStep
	public void saveStepExecution(StepExecution se) {
		this.se = se;
	}

	@AfterStep
	public void printNumberOfAttrCats(StepExecution se) {
		System.out
				.println("*********** Number Of Categories that are having attrs :  "
						+ numberOfAttrCount);
		System.out
				.println("*********** Number Of Categories dont have attrs :  "
						+ numberOfNoAttrCount);
		System.out.println("*********** Number Of Exceptions happened :  "
				+ exceptionCount);
	}
}