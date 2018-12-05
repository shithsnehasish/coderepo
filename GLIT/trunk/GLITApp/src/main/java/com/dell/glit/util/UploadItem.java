package com.dell.glit.util;

import org.springframework.web.multipart.MultipartFile;

public class UploadItem {

	private String name;
	private MultipartFile fileData;
	public UploadItem() {
	}
	
	public UploadItem(String name, MultipartFile fileData) {
		super();
		this.name = name;
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "UploadItem [name=" + name + ", fileData=" + fileData + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}

	
}
