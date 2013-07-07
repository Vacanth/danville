package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Image {
	
	@XmlEnum
	public enum ImageFormatEnum {
		JPEG,GIF,BMP,PNG,TIFF,EXIF;
	}
	
	private int imageId;
	private byte[] bytes;
	private String size;
	private ImageFormatEnum format;
	private String name;
	private String imgurl;
	
	public Image(){
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public ImageFormatEnum getFormat() {
		return format;
	}

	public void setFormat(ImageFormatEnum format) {
		this.format = format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
