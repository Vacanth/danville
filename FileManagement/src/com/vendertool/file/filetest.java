package com.vendertool.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class filetest {

	public static void main(String[] args) {
		
		FileMapperHelper fileMapperHelper = new AWSFileMapper();
		
		
		fileMapperHelper.deleteRootFolder("testmurali");
		fileMapperHelper.createRootFolder("testmurali");
		
		if (fileMapperHelper.isRootFolder("testMurali")) {
			System.out.println("Yes , it is root");
		} else {
			System.out.println("Not a root");
		}
		fileMapperHelper.deleteRootFolder("testmurali");
		try {
			fileMapperHelper.uploadFile("mybucket","testfile", createSampleFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 private static File createSampleFile() throws IOException {
	        File file = File.createTempFile("aws-java-sdk-", ".txt");
	        file.deleteOnExit();

	        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
	        writer.write("abcdefghijklmnopqrstuvwxyz\n");
	        writer.write("01234567890112345678901234\n");
	        writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
	        writer.write("01234567890112345678901234\n");
	        writer.write("abcdefghijklmnopqrstuvwxyz\n");
	        writer.close();

	        return file;
	    }
}
