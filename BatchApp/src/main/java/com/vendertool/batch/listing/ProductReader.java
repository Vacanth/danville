package com.vendertool.batch.listing;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.core.ProductCodeTypeEnum;
import com.vendertool.sharedtypes.rnr.AddProductRequest;

@Component("productreader")
public class ProductReader implements ItemReader<AddProductRequest> {
	private StepExecution stepExe;
	static String csvFilename = "C:\\nw\\testfile1.csv";
	static FileReader reader;
	static {
		try {
			reader = new FileReader(csvFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	CSVReader csvReader = new CSVReader(reader);

	@BeforeStep
	public void setExecution(StepExecution se) {
		stepExe = se;
	}

	@Override
	public AddProductRequest read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		String[] row = null;
		if (stepExe.getCommitCount() == 0) {
			csvReader.readNext();
		}
		if ((row = csvReader.readNext()) != null) {
			AddProductRequest request = new AddProductRequest();
			Product product = new Product();
			request.setProduct(product);
			product.setProductCode(row[1]);
			product.setProductCodeType(ProductCodeTypeEnum.valueOf(row[4]));
			product.setTitle(row[6]);
			product.setSku(row[0]);
			product.setQuantity((Integer.valueOf(row[10])));
			product.setProductCode(row[1]);
			return request;
		}
		return null;
	}
}