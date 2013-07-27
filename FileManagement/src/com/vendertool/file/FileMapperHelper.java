package com.vendertool.file;

import java.io.File;
import java.io.InputStream;

public interface FileMapperHelper {
	
	
	boolean isRootFolder(String rootFolderName);
	

	void createRootFolder(String rootFolderName);

	void deleteRootFolder(String rootFolderName);

	void uploadFile(String rootFolderName, String fileName, File file);
	
	void uploadFile(String rootFolderName, Long accountId,InputStream imageStream);

	void deleteFile(String rootFolderName, String fileName);

	void makePublic(String rootFolderName, String string);

	boolean isFilePublic(String rootFolderName, String keyName);

	boolean downloadFile(String rootFolderName, Long accountId, String fileName,File outputFile);

	InputStream downloadFile(String rootFolderName, String keyName);

	String getFileUrl(String rootFolderName, String keyName);

}
