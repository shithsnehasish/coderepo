package com.dell.glit.util;

import java.util.List;
import java.util.Map;

public class FormDTO {

	private String formName;
	private List<String> fieldsName;
	private List<Map<String, String>> fieldsData;
	
	public FormDTO() {
		
	}
	public FormDTO(String formName, List<String> fieldsName, List<Map<String, String>> fieldsData) {
		super();
		this.formName = formName;
		this.fieldsName = fieldsName;
		this.fieldsData = fieldsData;
	}
	
	@Override
	public String toString() {
		return "FormDTO [formName=" + formName + ", fieldsName=" + fieldsName + ", fieldsData=" + fieldsData + "]";
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public List<String> getFieldsName() {
		return fieldsName;
	}
	public void setFieldsName(List<String> fieldsName) {
		this.fieldsName = fieldsName;
	}
	public List<Map<String, String>> getFieldsData() {
		return fieldsData;
	}
	public void setFieldsData(List<Map<String, String>> fieldsData) {
		this.fieldsData = fieldsData;
	}
}
