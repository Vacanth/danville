package com.vendertool.file;


import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.sns.model.NotFoundException;

public class AWSFileMapper implements FileMapperHelper {

	private AmazonS3 s3;
	private String endpoint;
	

	@Override
	public boolean isRootFolder(String rootFolderName) {
		return s3.doesBucketExist(rootFolderName);
	}

	//ref : https://github.com/dwildt/aws-s3-java-howto
	
	public AWSFileMapper() {
		super();
		s3 = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider());
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		s3.setRegion(usWest2);

	}

	@Override
	public void createRootFolder(String rootFolderName) {
		s3.createBucket(rootFolderName);
	}

	@Override
	public void deleteRootFolder(String rootFolderName) {
		s3.deleteBucket(rootFolderName);
	}

	@Override
	public void uploadFile(String userName,String rootFolderName, String fileName, File file) {
		
		
		try {
			s3.getObject(new GetObjectRequest(rootFolderName, fileName).withKey(fileName));

	    } catch (NotFoundException nfe) {
	    	s3.putObject(new PutObjectRequest(rootFolderName, fileName, file).withKey(userName));
	    }
			
	}

	@Override
	public void deleteFile(String userName,String rootFolderName, String fileName) {
		s3.deleteObject(new DeleteObjectRequest(rootFolderName, fileName).withKey(userName));
	}

	@Override
	public void makePublic(String userName,String rootFolderName, String fileName) {
		s3.setObjectAcl(rootFolderName, fileName, CannedAccessControlList.PublicRead);
	}

	@Override
	public boolean isFilePublic(String userName,String rootFolderName, String fileName) {
		AccessControlList acl = s3.getObjectAcl(rootFolderName, fileName);
		for (Iterator<Grant> iterator = acl.getGrants().iterator(); iterator.hasNext();) {
			Grant grant = iterator.next();
			if(grant.getPermission().equals(Permission.Read) && grant.getGrantee().getIdentifier().equals("http://acs.amazonaws.com/groups/global/AllUsers"))
			  return true;
		}
		return false;
	}

	@Override
	public boolean downloadFile(String userName,String rootFolderName, Long accountId, String fileName,
			File outputFile) {
		String key = accountId + "";
		try{
		s3.getObject(new GetObjectRequest(rootFolderName, fileName).withKey(key), outputFile);
		return true;
		}catch (AmazonServiceException e) {
			e.printStackTrace();
			return false;
		} catch (AmazonClientException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void uploadFile(String userName,String rootFolderName, Long accountId,
			InputStream stream) {
		String key = accountId + "";
		s3.putObject(rootFolderName, key, stream, null);
	}

	@Override
	public InputStream downloadFile(String userName,String rootFolderName, String keyName) {
		S3Object s3Object = s3.getObject(rootFolderName, keyName);
		return s3Object.getObjectContent();
	}

	@Override
	public String getFileUrl(String userName,String rootFolderName, String keyName) {
		if(isFilePublic(userName,rootFolderName, keyName))
			return buildPublicFileURL(rootFolderName, keyName);
		else return null;
	}

	private String buildPublicFileURL(String rootFolderName, String keyName) {
		return "http://" + getEndpoint() + "/" + rootFolderName + "/" + keyName;
	}

	private void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	

}
