package com.vendertool.file;

import java.io.File;
import java.io.InputStream;

public interface FileMapperHelper {
	
	
	boolean isRootFolder(String rootFolderName);
	

	void createRootFolder(String rootFolderName);

	void deleteRootFolder(String rootFolderName);

	void uploadFile(String userName,String rootFolderName, String fileName, File file);
	
	void uploadFile(String userName,String rootFolderName, Long accountId,InputStream imageStream);

	void deleteFile(String userName,String rootFolderName, String fileName);

	void makePublic(String userName,String rootFolderName, String string);

	boolean isFilePublic(String userName,String rootFolderName, String keyName);

	boolean downloadFile(String userName,String rootFolderName, Long accountId, String fileName,File outputFile);

	InputStream downloadFile(String userName,String rootFolderName, String keyName);

	String getFileUrl(String userName,String rootFolderName, String keyName);

}
